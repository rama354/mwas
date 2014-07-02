/**
 * 
 */
package com.mwas.spring.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mwas.security.CertificateManagementFactory;
import com.mwas.security.CertificateManager;
import com.mwas.security.MWASKeyPairGenerator;
import com.mwas.security.SecurityConstants;

/**
 * @author asus
 *
 */
@Controller
@RequestMapping("/genssl.htm")
public class SSLController 
{

	@RequestMapping(method=RequestMethod.POST)
	public String makeSecureConnection(HttpServletRequest arg0) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException 
	{
		CertificateManager certManager = CertificateManagementFactory.getInstance()
											.createCertManager(SecurityConstants.X509_CERT_TYPE);
		
		//Evenutally parse certificate type from xml or file. create respective manager
		//and generate corresponding certificate
		//String host = InetAddress.getLocalHost().getHostName();
		String domainname = "CN=Ram,OU=Avaya,DC=localhost";
		int days = 180; String certname="common"; 
		//String sigalg=SecurityConstants.DSA_ENCRYPT;
		String sigalg="MD5WithRSA";
		
		Certificate selfsignedcert = certManager.generateCertificate(domainname, days, certname, sigalg);
		
		KeyStore keyStore = KeyStore.getInstance("JKS");
		keyStore.load(null, null);
		
		keyStore.setKeyEntry("common", MWASKeyPairGenerator.getPrivateKey(),"changeit".toCharArray(), new Certificate[]{selfsignedcert});
		
		//System.out.println("Contextpath "+arg0.getContextPath());
		
		File file = new File(System.getProperty("catalina.base"), "test.keystore");
		keyStore.store(new FileOutputStream(file),"changeit".toCharArray());
		// take care of Exception
		return "redirect:/login.htm";
		
	}	

}
