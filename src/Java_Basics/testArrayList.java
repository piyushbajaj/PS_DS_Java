package Java_Basics;

import java.util.ArrayList;
import java.util.Arrays;

public class testArrayList {

    static ArrayList<Category> arrayList1 = new ArrayList<>();
    static ArrayList<Category> arrayList2 = new ArrayList<>();
    public static class Category {
        private Integer catId;
        private String categoryDesc;

        public Integer getCatId() {
            return catId;
        }

        public void setCatId(Integer catId) {
            this.catId = catId;
        }

        public String getCategoryDesc() {
            return categoryDesc;
        }

        public void setCategoryDesc(String categoryDesc) {
            this.categoryDesc = categoryDesc == null ? null : categoryDesc.trim();
        }
    }

    static <T> ArrayList<T> subtract(ArrayList<T> alpha, ArrayList<T> beta) {
        ArrayList<T> gamma = new ArrayList<T>();
        alpha.forEach(n -> {if (!beta.contains(n)) gamma.add(n); });
        return gamma;
    }


    public static <T> ArrayList<T> subtract1 (ArrayList<T> alpha, ArrayList<T> beta) {
        for(int i =0; i< alpha.size(); i++){
            for(int j = 0; j < beta.size(); j++){
                System.out.println(alpha.get(i));
//                if(alpha.get(i).equals(array2.get(j))){
//                    minusArray.remove(i);
//                }
//                else{}
            }
        }
        return alpha;
    }

    public static void main(String[] args) {
        Category category = new Category();
        category.setCatId(1);
        category.setCategoryDesc("abc");
        arrayList1.add(category);
        arrayList2.add(category);
        category.setCatId(2);
        category.setCategoryDesc("abcd");
        arrayList1.add(category);

        System.out.println(Arrays.toString(arrayList1.toArray()));
        System.out.println(Arrays.toString(arrayList2.toArray()));

//        ArrayList<Category> arrayList3 = (ArrayList<Category>) arrayList1.stream()
//            .filter(e -> !arrayList2.contains(e))
//            .collect (Collectors.toList());
//
//
//        arrayList1.removeAll(arrayList2);
//
//        System.out.println(arrayList1);

        subtract1(arrayList1, arrayList2);

    }
}
