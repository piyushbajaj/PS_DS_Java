package Session.Uber.SQLLibrary;

import java.util.List;
import java.util.StringJoiner;

import static Session.Uber.SQLLibrary.SQLKeywords.FROM;
import static Session.Uber.SQLLibrary.SQLKeywords.GROUP_BY;
import static Session.Uber.SQLLibrary.SQLKeywords.HAVING;
import static Session.Uber.SQLLibrary.SQLKeywords.LIMIT;
import static Session.Uber.SQLLibrary.SQLKeywords.ORDER_BY;
import static Session.Uber.SQLLibrary.SQLKeywords.SELECT;
import static Session.Uber.SQLLibrary.SQLKeywords.SEMICOLON;
import static Session.Uber.SQLLibrary.SQLKeywords.WHERE;

/**
 * Project: DSAlgo
 * Package: Session.Uber.SQLLibrary
 * <p>
 * User: piyushbajaj
 * Date: 13/02/25
 * Time: 2:54 pm
 */
public class SQLQueryBuilder {
    protected String table;
    private List<String> columns;
    private String whereClause;
    private String groupBy;
    private String having;
    private String orderBy;
    private String limit;

    public SQLQueryBuilder setTable(String table) {
        this.table = table;
        return this;
    }

    public SQLQueryBuilder setColumns(List<String> columns) {
        this.columns = columns;
        return this;
    }

    public SQLQueryBuilder setWhere(String whereClause) {
        this.whereClause = whereClause;
        return this;
    }

    public SQLQueryBuilder setGroupBy(String groupBy) {
        this.groupBy = groupBy;
        return this;
    }

    public SQLQueryBuilder setHaving(String having) {
        this.having = having;
        return this;
    }

    public SQLQueryBuilder setOrderBy(String orderBy) {
        this.orderBy = orderBy;
        return this;
    }

    public SQLQueryBuilder setLimit(String limit) {
        this.limit = limit;
        return this;
    }

    public String build() {
        if (table == null || table.isEmpty()) {
            throw new IllegalStateException("Table name is required.");
        }

        if (columns == null || columns.isEmpty()) {
            throw new IllegalStateException("At least one column must be selected.");
        }

        StringJoiner query = new StringJoiner(" ");
        query.add(SELECT).add(String.join(",", columns));
        query.add(FROM).add(table);

        if (whereClause != null && !whereClause.isEmpty()) {
            query.add(WHERE).add(whereClause);
        }

        if (groupBy != null && !groupBy.isEmpty()) {
            query.add(GROUP_BY).add(groupBy);
        }

        if (having != null && !having.isEmpty()) {
            if (groupBy == null || groupBy.isEmpty()) {
                throw new IllegalStateException("At least one column must be selected in group by");
            }
            query.add(HAVING).add(having);
        }

        if (orderBy != null && !orderBy.isEmpty()) {
            query.add(ORDER_BY).add(orderBy);
        }

        if (limit != null && !limit.isEmpty()) {
            query.add(LIMIT).add(limit);
        }

        query.add(SEMICOLON);
        return query.toString();
    }
}
