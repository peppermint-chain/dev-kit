package com.peppermintchain.core.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The context in which the Smart Contract Executes. Gives access to contextual
 * information such as the Proposer Node, The DB Connection etc.
 * 
 * @author Pramod Chandersekhar
 *
 */
public interface PMCServiceContext {

    public static interface PendingTransaction {
	public String getModuleId();

	public String getContractId();

	public Map<String, Object> getParameters();
    }

    /**
     * @return The Database connection to be used for the transaction.
     */
    public Connection getDBConnection();

    /**
     * 
     * @return The current user;
     */
    public String getCurrentUser();

    /**
     * 
     * @param sql-
     *            The query to execute. Needs to be in JDBC Prepared Statement
     *            format.
     * @param clazz
     *            - The class of the object that needs to be mapped to the
     *            ResultSet.
     * @param args
     *            - Any arguments to the sql query.
     * @return A list of clazz objects. One for each record in the results.
     * @throws SQLException
     */
    public <T> List<T> runPreparedQuery(String sql, Class<T> clazz, Object... args) throws SQLException;

    /**
     * 
     * @param o
     *            - The object to insert. The clazz needs to have a @PCName
     *            annotation at the clazz level for the tableName. and at every
     *            field that needs to saved. The @PCName at each field gives the
     *            column name.
     * @throws SQLException
     */
    public void insert(Object o) throws SQLException;

    /**
     * 
     * @param o
     *            - The object to update. In addition to the annotations needed by
     *            insert, a @PCPrimaryKey is needed at the clazz level.
     * @throws SQLException
     */
    public void update(Object o) throws SQLException;

    /**
     * 
     * @param signingPeers
     *            - A List of Peer Nodes that will be called to sign the
     *            Transaction.
     * @param moduleId
     * @param contractId
     * @param parameters
     * @throws Exception
     */
    public void runContract(Set<String> signingPeers, String moduleId, String contractId,
	    Map<String, ? extends Object> parameters) throws Exception;

    /**
     * 
     * @return the set of pending transactions for this module.
     */
    public List<? extends PendingTransaction> getPendingTransactions();

    /**
     * 
     * @param moduleId
     * @param contractId
     * @param asType
     * @return
     * @throws Exception
     */
    public <T> List<T> getPendingTransactionsAs(String moduleId, String contractId, Class<T> asType) throws Exception;
}
