package com.abc.affiliate.dataadapter.batch.job;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.oxm.xstream.XStreamMarshaller;

import com.abc.affiliate.dataadapter.batch.processor.ProductProcessor;
import com.abc.affiliate.dataadapter.batch.writer.ProductKafkaSender;
import com.abc.affiliate.dataadapter.domain.product.Result.Products.Product;
import com.abc.affiliate.dataadapter.service.impl.ProductServiceImpl;
import com.thoughtworks.xstream.security.ExplicitTypePermission;

@Configuration
public class ProductJobConfig  {

    private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);
    
    @Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	private ProductProcessor productProcessor;
	
	@Bean
    @StepScope
    Resource inputFileResource(@Value("#{jobParameters[fileName]}") final String fileName, @Value("#{jobParameters[processId]}") final String processId) throws Exception {
		System.out.println(processId+"   "+ fileName);
		return new FileSystemResource(fileName);
    }
	
	@Bean
	public StaxEventItemReader<Product> reader() throws Exception {
		StaxEventItemReader<Product> reader = new StaxEventItemReader<Product>();
		reader.setResource(inputFileResource(null, null));
		reader.setFragmentRootElementName("product");
		
		Map<String,Class> aliasesMap =new HashMap<>();
		aliasesMap.put("product", Product.class);
		ExplicitTypePermission typePermission = new ExplicitTypePermission(new Class[] { Product.class });
		XStreamMarshaller marshaller = new XStreamMarshaller();
		marshaller.setAliases(aliasesMap);
		marshaller.setTypePermissions(typePermission);
		
		reader.setUnmarshaller(marshaller);
		return reader;
	}
	
	@Bean
    public ProductKafkaSender writer(){
        return new ProductKafkaSender();
    }
	
	@Bean
	public Step step() throws Exception {
		return stepBuilderFactory.get("step")
				.<Product, Product>chunk(1)
				.reader(reader())
				.processor(productProcessor)
				.writer(writer())
				.build();
	}

	@Bean
	public Job exportPerosnJob() throws Exception {
		return jobBuilderFactory.get("importProductJob")
				.incrementer(new RunIdIncrementer())
				.start(step())
				.build();
	}
	
}
