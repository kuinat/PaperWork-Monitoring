<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format" exclude-result-prefixes="fo">
    <xsl:template match="Driver">
        <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="simpleA4" page-height="29.7cm" page-width="21cm" margin-top="2cm" margin-bottom="2cm" margin-left="2cm" margin-right="2cm">
                    <fo:region-body column-count="3" />
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="simpleA4" >   >



                <fo:flow flow-name="xsl-region-body" >



                    <fo:block text-align="left"  >
                        <fo:external-graphic src="src//main//resources//xsl//companyLogo.jpg" width="10" height="10"/>

                    </fo:block>

                    <fo:block  text-align="center"  >
                        <fo:external-graphic src="src//main//resources//xsl//qrCode.png" width="10" height="10"/>


                    </fo:block>

                    <fo:block  font-size="12pt" font-weight="bold" space-after="20mm" text-align="right"  >


                         Car Rental-Selling Company



                    </fo:block>

                    <fo:block span="all" space-after="40mm">

                    </fo:block>



                    <fo:block span="all" font-size="16pt" font-weight="bold" space-before="20mm" space-after="5mm"  color="green" text-align="center" > EMPLOYMENT CONTRACT
                    </fo:block>
                    <fo:block span="all" font-size="12pt" space-after="5mm">
                        By the hereby contract, we testify that we as:
                        <fo:block span="all" font-size="12pt" font-weight="bold" space-before="5mm" > Car Rental-Selling Company</fo:block>
                        <fo:block span="all" font-size="12pt" font-weight="bold" space-after="5mm" > Business Licence Number: 124587</fo:block>
                        <fo:block span="all" font-size="12pt" space-after="5mm" > have employed:</fo:block>

                        <xsl:attribute Name = "font-weight">bold</xsl:attribute>
                        <fo:block span="all" font-size="12pt" space-after="5mm" > Mr/Mme
                            <fo:inline font-weight="bold" color="green"> <xsl:value-of select=" name" ></xsl:value-of> </fo:inline> As a  <fo:inline font-weight="bold"> Driver</fo:inline> in <fo:inline font-weight="bold">SELLING-Rental Car Company</fo:inline>.
                        </fo:block>

                    <fo:block span="all" font-size="12pt" > National identity Card:
                        <fo:inline font-weight="bold"><xsl:value-of select=" idCardNumber" ></xsl:value-of> </fo:inline>
                </fo:block>
                        <fo:block span="all" font-size="12pt" > License Number:
                            <fo:inline font-weight="bold"><xsl:value-of select=" licenceNumber" ></xsl:value-of></fo:inline>
                        </fo:block>

                        <fo:block span="all" font-size="12pt" space-after="5mm"> Phone Number:
                            <fo:inline font-weight="bold"><xsl:value-of select=" phoneNumber" ></xsl:value-of></fo:inline>
                        </fo:block>

                        <fo:block span="all" font-size="14pt" space-after="5mm" color="green">
                            WORK DETAILS
                        </fo:block>

                        <fo:block span="all" font-size="12pt" space-after="5mm">
                            The content of this work is about driving
                            all the customer who rent cars in our companies in different areas around the town and further.
                        </fo:block>

                        <fo:block span="all" font-size="14pt" space-after="5mm" color="green">
                            SALARY DETAILS
                        </fo:block>

                        <fo:block span="all" font-size="12pt">
                            The salary will be of 100 000 FCFA per month, that is 1 200 000 FCFA per year.
                        </fo:block>

                        <fo:block span="all" font-size="14pt" space-after="5mm" color="green">
                            PRIVACY STATEMENT
                        </fo:block>
                        <fo:block span="all" font-size="12pt" >
                            1. All the information gathered about the driver in our system are confidential between the driver and the company
                        </fo:block>
                        <fo:block span="all" font-size="12pt" >
                            2. Details about any customers of the society should not leak out.
                        </fo:block>
                        <fo:block span="all" font-size="12pt" >
                            2. Details or any crucial information about the company should not leak out or given to any other company.
                        </fo:block>
                        <fo:block span="all"  space-after="10mm">

                        </fo:block>
                        <fo:block span="all" font-size="12pt">
                            Date:-------------------------------

                        </fo:block>

                        <fo:block span="all" font-size="12pt">
                            Driver's Signature:-------------------------------

                        </fo:block>

                        <fo:block span="all" font-size="12pt">
                            Company's head
                            Signature:-------------------------------

                        </fo:block>

                    </fo:block>




                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>





</xsl:stylesheet>