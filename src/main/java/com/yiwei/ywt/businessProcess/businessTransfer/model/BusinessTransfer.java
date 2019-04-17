package com.yiwei.ywt.businessProcess.businessTransfer.model;

import com.yiwei.ywt.framework.model.BaseEntity;
import lombok.Data;


@Data
public class BusinessTransfer extends BaseEntity {

    private String familyNumber;

    private String waterAddress;

    private String newFamilyName;

    private String propertyAddress;

    private String newOwnerMobile;

    private String invoiceName;

    private String invoiceType;

    private String taxIdentififationNumber;

    private String companyRegistrationAddress;

    private String taxPhone;

    private String openAccountBank;

    private String bankAccount;

    private String collectTicketsEmail;

    private String other;

    private String companyType;

    private String companyCard;

    private String ownerCertificateno;

    private String managerName;

    private String managerMobile;

    private String templateAddress;

    private String businessLicenseImage;

    private String transferRegistration;

    private String corporateRepresenIdCardImage;

    private String managerIdCardImage;

    private String mobileCode;
}