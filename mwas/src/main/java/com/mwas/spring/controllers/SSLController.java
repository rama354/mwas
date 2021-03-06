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
import java.util.ArrayList;
import java.util.List;

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
		
		replaceServerXML();  ///from non-ssl to ssl
		
		serverShutdown();
		// take care of Exception
		return "redirect:/login.htm";
		
	}

	private void replaceServerXML() 
	{
		// TODO Auto-generated method stub
		StringBuffer serverxmlpath = new StringBuffer(System.getProperty("catalina.base"));
		serverxmlpath.append(System.getProperty("file.separator"));
		serverxmlpath.append("conf").append(System.getProperty("file.separator"));

		
		File  serverxml = new File(serverxmlpath.toString(),"server.xml");
		serverxml.renameTo(new File(serverxmlpath.toString(),"server_http.xml"));
		
		File httpsserverxml = new File(serverxmlpath.toString(),"server_https.xml");
		httpsserverxml.renameTo(new File(serverxmlpath.toString(),"server.xml"));
		
	}

	private void serverShutdown() 
	{
		// TODO Auto-generated method stub
		List<String> cmdlist = new ArrayList<String>();
		
		StringBuffer batchpath = new StringBuffer(System.getProperty("catalina.base"));
		batchpath.append(System.getProperty("file.separator"));
		batchpath.append(SecurityConstants.BIN).append(System.getProperty("file.separator"));
		batchpath.append(SecurityConstants.SERVER_SHUTDOWN_SCRIPT);
		
		cmdlist.add(batchpath.toString());
		ProcessBuilder pb = new ProcessBuilder(cmdlist);
		try {
			pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}	

}
