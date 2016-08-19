
package com.rsutilities.electricityservice.registration.webservice;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.7
 * 2016-08-19T11:54:35.565-05:00
 * Generated source version: 3.1.7
 * 
 */
public final class CustomerSoapService_CustomerSoapServicePort_Client {

    private static final QName SERVICE_NAME = new QName("http://service.customerservice.rsutilities.com/", "CustomerSoapServiceService");

    private CustomerSoapService_CustomerSoapServicePort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = CustomerSoapServiceService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        CustomerSoapServiceService ss = new CustomerSoapServiceService(wsdlURL, SERVICE_NAME);
        CustomerSoapService port = ss.getCustomerSoapServicePort();  
        
        {
        System.out.println("Invoking getServicePlan...");
        java.util.List<com.rsutilities.electricityservice.registration.webservice.ServicePlan> _getServicePlan__return = port.getServicePlan();
        System.out.println("getServicePlan.result=" + _getServicePlan__return);


        }

        System.exit(0);
    }

}
