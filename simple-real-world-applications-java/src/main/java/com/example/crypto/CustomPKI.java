package com.example.crypto;

import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.math.BigInteger;

public class CustomPKI {

    public static void main(String[] args) {
        try {
            // Simulate Root CA
            KeyPair rootCAPair = generateKeyPair();
            X509Certificate rootCACertificate = generateCertificate(rootCAPair, rootCAPair, "Root CA");

            // Simulate Issuing CA
            KeyPair issuingCAPair = generateKeyPair();
            X509Certificate issuingCACertificate = generateCertificate(issuingCAPair, rootCAPair, "Issuing CA");

            // Simulate Registration Authority
            PublicKey raPublicKey = issuingCAPair.getPublic();

            // Simulate End Entity Certificate Request
            KeyPair endEntityPair = generateKeyPair();
            X509Certificate endEntityCertificateRequest = generateCertificate(endEntityPair, raPublicKey, "End Entity Request");

            // Simulate Certificate Authority (CA) issuing End Entity Certificate
            X509Certificate endEntityCertificate = issueCertificate(endEntityCertificateRequest, issuingCAPair, "End Entity");

            // Verify End Entity Certificate
            verifyCertificate(endEntityCertificate, issuingCACertificate);

            // Simulate Revoking Certificate
            X509Certificate revokedCertificate = revokeCertificate(endEntityCertificate, issuingCAPair);

            // Verify Revoked Certificate
            verifyRevokedCertificate(revokedCertificate, issuingCACertificate);

            System.out.println("Custom PKI simulation completed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static KeyPair generateKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        return keyPairGenerator.generateKeyPair();
    }

    private static X509Certificate generateCertificate(KeyPair keyPair, Key issuerKey, String subject) throws Exception {
        // Simulate certificate generation using Bouncy Castle library
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

        X509CertificateGenerator certGen = new X509CertificateGenerator();
        certGen.setSerialNumber(BigInteger.valueOf(System.currentTimeMillis()));
        certGen.setIssuerDN(issuerKey);
        certGen.setNotBefore(new Date(System.currentTimeMillis()));
        certGen.setNotAfter(new Date(System.currentTimeMillis() + 365 * 24 * 60 * 60 * 1000)); // 1 year validity
        certGen.setSubjectDN(keyPair.getPublic());
        certGen.setPublicKey(keyPair.getPublic());
        certGen.setSignatureAlgorithm("SHA256WithRSAEncryption");

        // Simulate certificate signing
        return certGen.generate(issuerKey.getPrivate());
    }

    private static X509Certificate issueCertificate(X509Certificate certificateRequest, KeyPair issuerKeyPair, String subject) throws Exception {
        // Simulate certificate issuance by signing the certificate request
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        X509CertificateGenerator certGen = new X509CertificateGenerator();

        certGen.setSerialNumber(BigInteger.valueOf(System.currentTimeMillis()));
        certGen.setIssuerDN(issuerKeyPair.getPublic());
        certGen.setNotBefore(new Date(System.currentTimeMillis()));
        certGen.setNotAfter(new Date(System.currentTimeMillis() + 365 * 24 * 60 * 60 * 1000)); // 1 year validity
        certGen.setSubjectDN(certificateRequest.getSubjectX500Principal());
        certGen.setPublicKey(certificateRequest.getPublicKey());
        certGen.setSignatureAlgorithm("SHA256WithRSAEncryption");

        // Simulate certificate signing
        return certGen.generate(issuerKeyPair.getPrivate());
    }

    private static void verifyCertificate(X509Certificate certificate, X509Certificate issuerCertificate) throws Exception {
        // Simulate certificate verification using the issuer's public key
        certificate.verify(issuerCertificate.getPublicKey());
        System.out.println("Certificate verified successfully.");
    }

    private static X509Certificate revokeCertificate(X509Certificate certificate, KeyPair issuerKeyPair) throws Exception {
        // Simulate revoking a certificate by generating a new CRL
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

        X509CRLGenerator crlGen = new X509CRLGenerator();
        crlGen.setIssuerDN(issuerKeyPair.getPublic());
        crlGen.setThisUpdate(new Date(System.currentTimeMillis()));
        crlGen.setNextUpdate(new Date(System.currentTimeMillis() + 365 * 24 * 60 * 60 * 1000)); // Next update in 1 year
        crlGen.addCRLEntry(certificate.getSerialNumber(), new Date(), CRLReason.privilegeWithdrawn);

        // Simulate CRL signing
        return crlGen.generate(issuerKeyPair.getPrivate());
    }

    private static void verifyRevokedCertificate(X509Certificate revokedCertificate, X509Certificate issuerCertificate) throws Exception {
        // Simulate checking the revocation status using a Certificate Revocation List (CRL)
        X509CRL crl = generateCRL(revokedCertificate, issuerCertificate);

        // Simulate verifying the revoked status
        if (crl.isRevoked(revokedCertificate)) {
            System.out.println("Certificate revoked successfully.");
        } else {
            System.out.println("Certificate not revoked.");
        }
    }

    private static X509CRL generateCRL(X509Certificate revokedCertificate, X509Certificate issuerCertificate) throws Exception {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

        X509CRLGenerator crlGen = new X509CRLGenerator();
        crlGen.setIssuerDN(issuerCertificate.getSubjectX500Principal());
        crlGen.setThisUpdate(new Date(System.currentTimeMillis()));
        crlGen.setNextUpdate(new Date(System.currentTimeMillis() + 365 * 24 * 60 * 60 * 1000)); // Next update in 1 year
        crlGen.addCRLEntry(revokedCertificate.getSerialNumber(), new Date(), CRLReason.privilegeWithdrawn);

        // Simulate CRL signing
        return crlGen.generate(issuerCertificate.getPrivateKey());
    }
}
