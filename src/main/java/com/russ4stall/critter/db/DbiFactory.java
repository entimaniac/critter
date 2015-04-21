package com.russ4stall.critter.db;

import com.russ4stall.critter.utils.CritterProperties;
import org.skife.jdbi.v2.DBI;

/**
 * Date: 10/15/14
 * Time: 2:46 PM
 *
 * @author Russ Forstall
 */
public class DbiFactory {
    private DBI dbi;

    public DbiFactory() {
        dbi = new DBI(
                CritterProperties.DB_URL,
                CritterProperties.DB_USER,
                CritterProperties.DB_PASSWORD
        );
    }

    public DBI getDbi() {
        return dbi;
    }
}
