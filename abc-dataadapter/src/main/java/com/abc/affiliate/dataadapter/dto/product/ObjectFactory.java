//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.05.31 at 12:49:25 PM CEST 
//


package com.abc.affiliate.dataadapter.dto.product;

import java.io.Serializable;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.abc.affiliate.dataadapter.domain.product package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory implements Serializable {

    private final static QName _Sku_QNAME = new QName("urn:com:tradedoubler:pf:model:xml:common", "sku");
    private final static QName _Brand_QNAME = new QName("urn:com:tradedoubler:pf:model:xml:common", "brand");
    private final static QName _Warranty_QNAME = new QName("urn:com:tradedoubler:pf:model:xml:common", "warranty");
    private final static QName _Model_QNAME = new QName("urn:com:tradedoubler:pf:model:xml:common", "model");
    private final static QName _InStock_QNAME = new QName("urn:com:tradedoubler:pf:model:xml:common", "inStock");
    private final static QName _FeedId_QNAME = new QName("urn:com:tradedoubler:pf:model:xml:common", "feedId");
    private final static QName _ProgramName_QNAME = new QName("urn:com:tradedoubler:pf:model:xml:common", "programName");
    private final static QName _PromoText_QNAME = new QName("urn:com:tradedoubler:pf:model:xml:common", "promoText");
    private final static QName _Ean_QNAME = new QName("urn:com:tradedoubler:pf:model:xml:common", "ean");
    private final static QName _Manufacturer_QNAME = new QName("urn:com:tradedoubler:pf:model:xml:common", "manufacturer");
    private final static QName _Description_QNAME = new QName("urn:com:tradedoubler:pf:model:xml:common", "description");
    private final static QName _Availability_QNAME = new QName("urn:com:tradedoubler:pf:model:xml:common", "availability");
    private final static QName _DeliveryTime_QNAME = new QName("urn:com:tradedoubler:pf:model:xml:common", "deliveryTime");
    private final static QName _Isbn_QNAME = new QName("urn:com:tradedoubler:pf:model:xml:common", "isbn");
    private final static QName _ProductUrl_QNAME = new QName("urn:com:tradedoubler:pf:model:xml:common", "productUrl");
    private final static QName _TechSpecs_QNAME = new QName("urn:com:tradedoubler:pf:model:xml:common", "techSpecs");
    private final static QName _Name_QNAME = new QName("urn:com:tradedoubler:pf:model:xml:common", "name");
    private final static QName _Size_QNAME = new QName("urn:com:tradedoubler:pf:model:xml:common", "size");
    private final static QName _ProgramLogo_QNAME = new QName("urn:com:tradedoubler:pf:model:xml:common", "programLogo");
    private final static QName _Condition_QNAME = new QName("urn:com:tradedoubler:pf:model:xml:common", "condition");
    private final static QName _Weight_QNAME = new QName("urn:com:tradedoubler:pf:model:xml:common", "weight");
    private final static QName _Upc_QNAME = new QName("urn:com:tradedoubler:pf:model:xml:common", "upc");
    private final static QName _Mpn_QNAME = new QName("urn:com:tradedoubler:pf:model:xml:common", "mpn");
    private final static QName _ShortDescription_QNAME = new QName("urn:com:tradedoubler:pf:model:xml:common", "shortDescription");
    private final static QName _ShippingCost_QNAME = new QName("urn:com:tradedoubler:pf:model:xml:common", "shippingCost");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.abc.affiliate.dataadapter.domain.product
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Result }
     * 
     */
    public Result createResult() {
        return new Result();
    }

    /**
     * Create an instance of {@link Categories }
     * 
     */
    public Categories createCategories() {
        return new Categories();
    }

    /**
     * Create an instance of {@link Fields }
     * 
     */
    public Fields createFields() {
        return new Fields();
    }

    /**
     * Create an instance of {@link Result.Products }
     * 
     */
    public Result.Products createResultProducts() {
        return new Result.Products();
    }

    /**
     * Create an instance of {@link Result.Products.Product }
     * 
     */
    public Result.Products.Product createResultProductsProduct() {
        return new Result.Products.Product();
    }

    /**
     * Create an instance of {@link Result.Products.Product.Offers }
     * 
     */
    public Result.Products.Product.Offers createResultProductsProductOffers() {
        return new Result.Products.Product.Offers();
    }

    /**
     * Create an instance of {@link Result.Products.Product.Offers.Offer }
     * 
     */
    public Result.Products.Product.Offers.Offer createResultProductsProductOffersOffer() {
        return new Result.Products.Product.Offers.Offer();
    }

    /**
     * Create an instance of {@link ProductImage }
     * 
     */
    public ProductImage createProductImage() {
        return new ProductImage();
    }

    /**
     * Create an instance of {@link Price }
     * 
     */
    public Price createPrice() {
        return new Price();
    }

    /**
     * Create an instance of {@link Categories.Category }
     * 
     */
    public Categories.Category createCategoriesCategory() {
        return new Categories.Category();
    }

    /**
     * Create an instance of {@link Fields.Field }
     * 
     */
    public Fields.Field createFieldsField() {
        return new Fields.Field();
    }

    /**
     * Create an instance of {@link Result.Products.Product.Offers.Offer.PriceHistory }
     * 
     */
    public Result.Products.Product.Offers.Offer.PriceHistory createResultProductsProductOffersOfferPriceHistory() {
        return new Result.Products.Product.Offers.Offer.PriceHistory();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:tradedoubler:pf:model:xml:common", name = "sku")
    public JAXBElement<String> createSku(String value) {
        return new JAXBElement<String>(_Sku_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:tradedoubler:pf:model:xml:common", name = "brand")
    public JAXBElement<String> createBrand(String value) {
        return new JAXBElement<String>(_Brand_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:tradedoubler:pf:model:xml:common", name = "warranty")
    public JAXBElement<String> createWarranty(String value) {
        return new JAXBElement<String>(_Warranty_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:tradedoubler:pf:model:xml:common", name = "model")
    public JAXBElement<String> createModel(String value) {
        return new JAXBElement<String>(_Model_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:tradedoubler:pf:model:xml:common", name = "inStock")
    public JAXBElement<Integer> createInStock(Integer value) {
        return new JAXBElement<Integer>(_InStock_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:tradedoubler:pf:model:xml:common", name = "feedId")
    public JAXBElement<Long> createFeedId(Long value) {
        return new JAXBElement<Long>(_FeedId_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:tradedoubler:pf:model:xml:common", name = "programName")
    public JAXBElement<String> createProgramName(String value) {
        return new JAXBElement<String>(_ProgramName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:tradedoubler:pf:model:xml:common", name = "promoText")
    public JAXBElement<String> createPromoText(String value) {
        return new JAXBElement<String>(_PromoText_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:tradedoubler:pf:model:xml:common", name = "ean")
    public JAXBElement<String> createEan(String value) {
        return new JAXBElement<String>(_Ean_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:tradedoubler:pf:model:xml:common", name = "manufacturer")
    public JAXBElement<String> createManufacturer(String value) {
        return new JAXBElement<String>(_Manufacturer_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:tradedoubler:pf:model:xml:common", name = "description")
    public JAXBElement<String> createDescription(String value) {
        return new JAXBElement<String>(_Description_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:tradedoubler:pf:model:xml:common", name = "availability")
    public JAXBElement<String> createAvailability(String value) {
        return new JAXBElement<String>(_Availability_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:tradedoubler:pf:model:xml:common", name = "deliveryTime")
    public JAXBElement<String> createDeliveryTime(String value) {
        return new JAXBElement<String>(_DeliveryTime_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:tradedoubler:pf:model:xml:common", name = "isbn")
    public JAXBElement<String> createIsbn(String value) {
        return new JAXBElement<String>(_Isbn_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:tradedoubler:pf:model:xml:common", name = "productUrl")
    public JAXBElement<String> createProductUrl(String value) {
        return new JAXBElement<String>(_ProductUrl_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:tradedoubler:pf:model:xml:common", name = "techSpecs")
    public JAXBElement<String> createTechSpecs(String value) {
        return new JAXBElement<String>(_TechSpecs_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:tradedoubler:pf:model:xml:common", name = "name")
    public JAXBElement<String> createName(String value) {
        return new JAXBElement<String>(_Name_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:tradedoubler:pf:model:xml:common", name = "size")
    public JAXBElement<String> createSize(String value) {
        return new JAXBElement<String>(_Size_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:tradedoubler:pf:model:xml:common", name = "programLogo")
    public JAXBElement<String> createProgramLogo(String value) {
        return new JAXBElement<String>(_ProgramLogo_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:tradedoubler:pf:model:xml:common", name = "condition")
    public JAXBElement<String> createCondition(String value) {
        return new JAXBElement<String>(_Condition_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:tradedoubler:pf:model:xml:common", name = "weight")
    public JAXBElement<String> createWeight(String value) {
        return new JAXBElement<String>(_Weight_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:tradedoubler:pf:model:xml:common", name = "upc")
    public JAXBElement<String> createUpc(String value) {
        return new JAXBElement<String>(_Upc_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:tradedoubler:pf:model:xml:common", name = "mpn")
    public JAXBElement<String> createMpn(String value) {
        return new JAXBElement<String>(_Mpn_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:tradedoubler:pf:model:xml:common", name = "shortDescription")
    public JAXBElement<String> createShortDescription(String value) {
        return new JAXBElement<String>(_ShortDescription_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:tradedoubler:pf:model:xml:common", name = "shippingCost")
    public JAXBElement<String> createShippingCost(String value) {
        return new JAXBElement<String>(_ShippingCost_QNAME, String.class, null, value);
    }

}
