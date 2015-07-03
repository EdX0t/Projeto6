
package ar.p4.ejb.webserviceRest;

import java.util.ArrayList;
import java.util.List;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;




@XmlRootElement(name = "ArrayOfSearchLyricResult", namespace="http://api.chartlyrics.com/")
public class ArrayOfSearchLyricResult1 {

    @XmlElement(name = "SearchLyricResult")
    protected List<SearchLyricResult1> searchLyricResult1;

   
    public List<SearchLyricResult1> getSearchLyricResult() {
        if (searchLyricResult1 == null) {
            searchLyricResult1 = new ArrayList<SearchLyricResult1>();
        }
        return this.searchLyricResult1;
    }

}
