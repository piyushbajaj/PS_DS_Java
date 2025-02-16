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
 * Time: 3:19 pm
 */
public class SelectQueryBuilder extends SQLQueryBuilder {
    private List<String> columns;
    private String whereClause;
    private String groupBy;
    private String having;
    private String orderBy;
    private String limit;

    public SelectQueryBuilder setColumns(List<String> columns) {
        this.columns = columns;
        return this;
    }

    public SelectQueryBuilder setWhere(String whereClause) {
        this.whereClause = whereClause;
        return this;
    }

    public SelectQueryBuilder setGroupBy(String groupBy) {
        this.groupBy = groupBy;
        return this;
    }

    public SelectQueryBuilder setHaving(String having) {
        this.having = having;
        return this;
    }

    public SelectQueryBuilder setOrderBy(String orderBy) {
        this.orderBy = orderBy;
        return this;
    }

    public SelectQueryBuilder setLimit(String limit) {
        this.limit = limit;
        return this;
    }

    @Override
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
