/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author adam-carter
 */
public interface Searchable {
    public boolean search (String searchTerm);
    public int getFoundIndex();
    public void setFoundIndex(int tableMemberindex);
    public boolean getFound();
    public void setFound(boolean searchResult);
    public int getSearchByField();
    public void setSearchByField(int fieldIndex);
}
