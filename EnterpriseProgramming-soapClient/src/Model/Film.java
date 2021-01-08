/**
 * Film.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Model;

public class Film  implements java.io.Serializable {
    private java.lang.String filmCredits;

    private java.lang.String filmDuration;

    private int filmID;

    private java.lang.String filmName;

    private java.lang.String filmReview;

    private int filmYear;

    public Film() {
    }

    public Film(
           java.lang.String filmCredits,
           java.lang.String filmDuration,
           int filmID,
           java.lang.String filmName,
           java.lang.String filmReview,
           int filmYear) {
           this.filmCredits = filmCredits;
           this.filmDuration = filmDuration;
           this.filmID = filmID;
           this.filmName = filmName;
           this.filmReview = filmReview;
           this.filmYear = filmYear;
    }


    /**
     * Gets the filmCredits value for this Film.
     * 
     * @return filmCredits
     */
    public java.lang.String getFilmCredits() {
        return filmCredits;
    }


    /**
     * Sets the filmCredits value for this Film.
     * 
     * @param filmCredits
     */
    public void setFilmCredits(java.lang.String filmCredits) {
        this.filmCredits = filmCredits;
    }


    /**
     * Gets the filmDuration value for this Film.
     * 
     * @return filmDuration
     */
    public java.lang.String getFilmDuration() {
        return filmDuration;
    }


    /**
     * Sets the filmDuration value for this Film.
     * 
     * @param filmDuration
     */
    public void setFilmDuration(java.lang.String filmDuration) {
        this.filmDuration = filmDuration;
    }


    /**
     * Gets the filmID value for this Film.
     * 
     * @return filmID
     */
    public int getFilmID() {
        return filmID;
    }


    /**
     * Sets the filmID value for this Film.
     * 
     * @param filmID
     */
    public void setFilmID(int filmID) {
        this.filmID = filmID;
    }


    /**
     * Gets the filmName value for this Film.
     * 
     * @return filmName
     */
    public java.lang.String getFilmName() {
        return filmName;
    }


    /**
     * Sets the filmName value for this Film.
     * 
     * @param filmName
     */
    public void setFilmName(java.lang.String filmName) {
        this.filmName = filmName;
    }


    /**
     * Gets the filmReview value for this Film.
     * 
     * @return filmReview
     */
    public java.lang.String getFilmReview() {
        return filmReview;
    }


    /**
     * Sets the filmReview value for this Film.
     * 
     * @param filmReview
     */
    public void setFilmReview(java.lang.String filmReview) {
        this.filmReview = filmReview;
    }


    /**
     * Gets the filmYear value for this Film.
     * 
     * @return filmYear
     */
    public int getFilmYear() {
        return filmYear;
    }


    /**
     * Sets the filmYear value for this Film.
     * 
     * @param filmYear
     */
    public void setFilmYear(int filmYear) {
        this.filmYear = filmYear;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Film)) return false;
        Film other = (Film) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.filmCredits==null && other.getFilmCredits()==null) || 
             (this.filmCredits!=null &&
              this.filmCredits.equals(other.getFilmCredits()))) &&
            ((this.filmDuration==null && other.getFilmDuration()==null) || 
             (this.filmDuration!=null &&
              this.filmDuration.equals(other.getFilmDuration()))) &&
            this.filmID == other.getFilmID() &&
            ((this.filmName==null && other.getFilmName()==null) || 
             (this.filmName!=null &&
              this.filmName.equals(other.getFilmName()))) &&
            ((this.filmReview==null && other.getFilmReview()==null) || 
             (this.filmReview!=null &&
              this.filmReview.equals(other.getFilmReview()))) &&
            this.filmYear == other.getFilmYear();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getFilmCredits() != null) {
            _hashCode += getFilmCredits().hashCode();
        }
        if (getFilmDuration() != null) {
            _hashCode += getFilmDuration().hashCode();
        }
        _hashCode += getFilmID();
        if (getFilmName() != null) {
            _hashCode += getFilmName().hashCode();
        }
        if (getFilmReview() != null) {
            _hashCode += getFilmReview().hashCode();
        }
        _hashCode += getFilmYear();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Film.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Model", "Film"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filmCredits");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Model", "filmCredits"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filmDuration");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Model", "filmDuration"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filmID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Model", "filmID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filmName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Model", "filmName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filmReview");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Model", "filmReview"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filmYear");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Model", "filmYear"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
