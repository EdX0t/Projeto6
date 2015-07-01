
package ar.p4.ejb.webserviceRest;

import java.util.ArrayList;
import java.util.List;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;




@XmlRootElement(name = "ArrayOfSearchLyricResult", namespace="http://api.chartlyrics.com/")
public class ArrayOfSearchLyricResult {

    @XmlElement(name = "SearchLyricResult")
    protected List<SearchLyricResult> searchLyricResult;

   
    public List<SearchLyricResult> getSearchLyricResult() {
        if (searchLyricResult == null) {
            searchLyricResult = new ArrayList<SearchLyricResult>();
        }
        return this.searchLyricResult;
    }

}
