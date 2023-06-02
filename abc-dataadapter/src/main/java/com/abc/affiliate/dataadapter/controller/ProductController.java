package com.abc.affiliate.dataadapter.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.hibernate.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.abc.affiliate.dataadapter.controller.exception.ErrorResponse;
import com.abc.affiliate.dataadapter.dto.common.ProcessIdResult;
import com.abc.affiliate.dataadapter.dto.common.ProcessIdStatus;
import com.abc.affiliate.dataadapter.service.ProductService;

@RestController
@RequestMapping("/v1/product")
public class ProductController {
	
	private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	@Qualifier("productServiceImpl")
    private ProductService productService;

    @PostMapping("/upload")
    public ResponseEntity<ProcessIdResult> upload(HttpServletRequest request) throws Exception {
    	
    	if(!ServletFileUpload.isMultipartContent(request)) {
            throw new BadRequestException("Multipart request expected");
        }

        String processId = UUID.randomUUID().toString();
        productService.upload(processId, new ServletFileUpload().getItemIterator(request));
        
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(ProcessIdResult.builder().processId(processId).build());
    }
    
	@GetMapping("/status")
	public ResponseEntity<ProcessIdStatus> getStatus(@RequestParam("processId") String processId) {

		ProcessIdStatus status = productService.getStatus(processId); 
		if (status == null) {
			throw new ObjectNotFoundException(processId, "Data not found.");
		}
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

    /* Controller level exception  */
    public static class BadRequestException extends RuntimeException {
        public BadRequestException(String detail) {
            super(detail);
        }
    }
    
    /* Controller level exception handling */
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {BadRequestException.class})
    public ResponseEntity<Object> handleMethodArgumentNotValid(MissingServletRequestParameterException ex) {
    	
    	ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
    
}