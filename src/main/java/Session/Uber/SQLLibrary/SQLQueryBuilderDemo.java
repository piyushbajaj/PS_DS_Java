package Session.Uber.SQLLibrary;

import java.util.Arrays;

/**
 * Project: DSAlgo
 * Package: Session.Uber.SQLLibrary
 * <p>
 * User: piyushbajaj
 * Date: 13/02/25
 * Time: 3:00 pm
 */
public class SQLQueryBuilderDemo {
    public static void main(String[] args) {
        SQLQueryBuilder queryBuilder = new SQLQueryBuilder()
            .setTable("abcd")
            .setColumns(Arrays.asList("a", "b"))
            .setWhere("condition1")
            .setGroupBy("a")
            .setHaving("condition2")
            .setOrderBy("b")
            .setLimit("n");

        String sqlQuery = queryBuilder.build();
        System.out.println(sqlQuery);
    }
}
