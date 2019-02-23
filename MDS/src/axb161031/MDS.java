/** Starter code for LP3
 *  @Abinash Bhattarai
 */

package axb161031;

// If you want to create additional classes, place them in this file as subclasses of MDS

import java.lang.reflect.Array;
import java.util.*;

public class MDS {
    HashMap<Integer,Entry> table;

    public class Entry{
        int id;
        int price;
        PriorityQueue<Integer> description;
        int sum;

        public Entry(int id, int price, int sum){
            this.id=id;
            this.price=price;
            description= new PriorityQueue<>();
            this.sum=sum;
        }

        public int getId(){
           return this.id;
        }

        public int getPrice(){
            return this.price;
        }

        public void setPrice(int price){
            this.price=price;
        }

        public PriorityQueue<Integer> getDescription(){
            return this.description;
        }

        public void setSumDescritption(int sum){
            this.sum = sum;
        }

        public int getSumDescription() {
            return this.sum;

        }

        public void setDescription(PriorityQueue<Integer> description){
            this.description=description;
        }
    }
    // Add fields of MDS here

    // Constructors
    public MDS() {
        table= new HashMap<>();
    }

    /* Public methods of MDS. Do not change their signatures.
       __________________________________________________________________
       a. Insert(id,price,list): insert a new item whose description is given
       in the list.  If an entry with the same id already exists, then its
       description and price are replaced by the new values, unless list
       is null or empty, in which case, just the price is updated.
       Returns 1 if the item is new, and 0 otherwise.
    */
    public int insert(int id, int price, java.util.List<Integer> list) {
        Entry data= findEntry(id);

        PriorityQueue<Integer> description= new PriorityQueue<>();
        int sum=0;
        for(int values: list){
            description.add(values);
            sum+=values;
        }
        //If data already exists
        if(data!=null){
            data.setPrice(price);
            data.setDescription(description);
            data.setSumDescritption(sum);
            return 0;
        }
        else{
            data= new Entry(id, price,sum);
            data.setDescription(description);
            table.put(id, data);
            return 1;
        }
    }

    // b. Find(id): return price of item with given id (or 0, if not found).
    public int find(int id) {
        Entry data=findEntry(id);
        if(data!=null){
            return data.getPrice();
        }
        return 0;
    }

    public Entry findEntry(int id){
        if(this.table.containsKey(id))
            return table.get(id);
        else
            return null;

    }

    /*
       c. Delete(id): delete item from storage.  Returns the sum of the
       ints that are in the description of the item deleted,
       or 0, if such an id did not exist.
    */
    public int delete(int id) {
        Entry data=findEntry(id);
        if(data!=null){
            int sumValue=data.getSumDescription();
            table.remove(id);
            return sumValue;
        }
        return 0;
    }

    /*
       d. FindMinPrice(n): given an integer, find items whose description
       contains that number (exact match with one of the ints in the
       item's description), and return lowest price of those items.
       Return 0 if there is no such item.
    */
    public int findMinPrice(int n) {
        Integer minPrice= Integer.MAX_VALUE;
        Set<Integer> keys= table.keySet();
        int price=0;
        for(int key: keys){
            price=descriptionPrice(n, table.get(key));
            if(price<minPrice && price!= -1)
                minPrice=price;
        }
        return minPrice <Integer.MAX_VALUE ? minPrice :0 ;
    }

    /*
       e. FindMaxPrice(n): given an integer, find items whose description
       contains that number, and return highest price of those items.
       Return 0 if there is no such item.
    */
    public int findMaxPrice(int n)
    {
        Integer maxPrice= Integer.MIN_VALUE;
        Set<Integer> keys= table.keySet();
        int price=0;
        for(int key: keys){
            price=descriptionPrice(n, table.get(key));
            if(price>maxPrice && price!= -1)
                maxPrice=price;
        }
        return maxPrice>Integer.MIN_VALUE? maxPrice:0 ;
    }

    /*
       f. FindPriceRange(n,low,high): given int n, find the number
       of items whose description contains n, and in addition,
       their prices fall within the given range, [low, high].
    */
    public int findPriceRange(int n, int low, int high) {
        Set<Integer> keys= table.keySet();
        int price=0;
        int count=0;
        for(int key: keys){
            price=descriptionPrice(n, table.get(key));
            if(price!=-1 && price>low && price<high){
                count++;
            }
        }

        return count;
    }

    /*
       g. descriptionPrice(int n, Entry data): given int n and Entry data find if
       that entry contains n in the description or not,
       and if it does return price otherwise 0.
    */

    public int descriptionPrice(int n, Entry data){

        if(data.getDescription().contains(n))
            return data.getPrice();

        return -1;
    }



    /*
      h. RemoveNames(id, list): Remove elements of list from the description of id.
       Returns the sum of the numbers that are actually
      deleted from the description of id.  Returns 0 if there is no such id.
    */
    public int removeNames(int id, java.util.List<Integer> list) {
        Entry data= findEntry(id);
        PriorityQueue<Integer> description = new PriorityQueue<>();

        int newSum=0;
        PriorityQueue<Integer> listQ= new PriorityQueue<>(list);
        if(data!=null){
            int sum=0;;
            for(int element: data.description){
                if(!listQ.contains(element)){
                    description.add(element);
                    newSum += element;
                }
                else{
                    listQ.remove(element);
                    sum+= element;
                }
            }
            data.setDescription(description);
            data.setSumDescritption(newSum);
            return sum;

        }
        return 0;
    }
}

