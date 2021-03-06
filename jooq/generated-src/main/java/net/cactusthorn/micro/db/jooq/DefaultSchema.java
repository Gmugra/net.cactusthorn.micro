/*
 * This file is generated by jOOQ.
 */
package net.cactusthorn.micro.db.jooq;


import java.util.Arrays;
import java.util.List;

import net.cactusthorn.micro.db.jooq.tables.Address;
import net.cactusthorn.micro.db.jooq.tables.Country;
import net.cactusthorn.micro.db.jooq.tables.Customer;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DefaultSchema extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>DEFAULT_SCHEMA</code>
     */
    public static final DefaultSchema DEFAULT_SCHEMA = new DefaultSchema();

    /**
     * The table <code>address</code>.
     */
    public final Address ADDRESS = Address.ADDRESS;

    /**
     * The table <code>country</code>.
     */
    public final Country COUNTRY = Country.COUNTRY;

    /**
     * The table <code>customer</code>.
     */
    public final Customer CUSTOMER = Customer.CUSTOMER;

    /**
     * No further instances allowed
     */
    private DefaultSchema() {
        super("", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.<Table<?>>asList(
            Address.ADDRESS,
            Country.COUNTRY,
            Customer.CUSTOMER);
    }
}
