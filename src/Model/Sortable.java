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
public interface Sortable {
    public void sort();
    public int getSortField();
    public void setSortField(int sortField);
}
