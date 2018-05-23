package unbbayes.controller;

import unbbayes.io.BaseIO;
import unbbayes.prs.Edge;
import unbbayes.prs.Graph;
import unbbayes.prs.Network;
import unbbayes.prs.Node;
import unbbayes.prs.bn.ProbabilisticNode;
import unbbayes.prs.bn.SingleEntityNetwork;
import unbbayes.util.extension.bn.inference.IInferenceAlgorithm;

/**
 * This is a common interface for NetworkController.
 * This is a Mediator design pattern since almost all communication is managed using
 * this.
 * @author Shou Matsumoto
 *
 */
public interface INetworkMediator {

	// TODO ROMMEL - CHANGE THIS!! NEW MODELING!!
	public abstract IInferenceAlgorithm getInferenceAlgorithm();

	public abstract void setInferenceAlgorithm(
			IInferenceAlgorithm inferenceAlgorithm);

	/**
	 *  Get the single entity network.
	 *
	 * @return The single entity network.
	 */
	public abstract SingleEntityNetwork getSingleEntityNetwork();

	/**
	 * Get the network being controlled.
	 * @return The network being controlled.
	 */
	public abstract Network getNetwork();

	/**
	 * Obtains the network in a Graph format
	 * @return
	 */
	public abstract Graph getGraph();

	/**
	 * Initialize the junction tree beliefs.
	 */
	public abstract void initialize();
	
	/**
	 * Reset the belief of the selected node.
	 */
	public abstract void removeEvidence(Node node);

	/**
	 * Creates and shows the panel to edit the node's table.
	 * @param node The table owner.
	 */
	public abstract void createTable(Node node);

	/**
	 * Creates and shows the panel where the user can edit the 
	 * continuous node normal distribution.
	 * @param node The continuous node to create the distribution pane for.
	 * @deprecated Continuous node is no longer supported in UnBBayes core. It has 
	 * now been replaced by the CPS plugin available at http://sourceforge.net/projects/prognos/.
	 */
	//public abstract void createContinuousDistribution(ContinuousNode node);

	/**
	 * Creates and shows the panel where the user can edit the discrete 
	 * node table.
	 * @param node The discrete node to create the table pan for.
	 */
	public abstract void createDiscreteTable(Node node);

	/**
	 *  Propagate the evidences of the SingleEntityNetwork.
	 */
	public abstract void propagate();

	/**
	 *  Compile the SingleEntityNetwork.
	 *
	 * @return True if it compiles with no error and false otherwise.
	 */
	public abstract boolean compileNetwork();

	/**
	 * Change the GUI to allow PN evaluation.
	 */
	public abstract void evaluateNetwork();

	/**
	 * Insert a new continuous node in the SingleEntityNetwork with 
	 * the standard label and description.
	 *
	 * @param x The x position of the new node.
	 * @param y The y position of the new node.
	 */
	public abstract Node insertContinuousNode(double x, double y);

	/**
	 * Insert a new probabilistic node in the SingleEntityNetwork with 
	 * the standard label and description.
	 *
	 * @param x The x position of the new node.
	 * @param y The y position of the new node.
	 */
	public abstract Node insertProbabilisticNode(double x, double y);

	/**
	 * Insert a new decision node in the SingleEntityNetwork with
	 * the standard label and description.
	 *
	 * @param x The x position of the new node.
	 * @param y The y position of the new node.
	 */
	public abstract Node insertDecisionNode(double x, double y);

	/**
	 * Insert a new utility node in the SingleEntityNetwork with
	 * the standard label and description.
	 *
	 * @param x The x position of the new node.
	 * @param y The y position of the new node.
	 */
	public abstract Node insertUtilityNode(double x, double y);

	/**
	 * Show the explanation properties for the given node.
	 * @param node The node to show the explanation properties.
	 */
	public abstract void showExplanationProperties(ProbabilisticNode node);

	/**
	 * Insert a new edge in the network.
	 *
	 * @param edge The new edge to be inserted.
	 */
	public abstract boolean insertEdge(Edge edge) throws Exception;

	/**
	 *  Insert a new state for the given node.
	 *
	 * @param node The selected node to insert the new state.
	 */
	public abstract void insertState(Node node);

	/**
	 *  Remove the last state from the given node.
	 *
	 * @param node The selected node to remove the last state.
	 */
	public abstract void removeState(Node node);

	/**
	 * Delete the selected object from the network.
	 * @param selected The selected object to delete.
	 */
	//by young
	public abstract void deleteSelected(Object selected);

	/**
	 * Save the network image to a file.
	 */
	public abstract void saveNetImage();

	/**
	 * Save the table image to a file.
	 */
	public abstract void saveTableImage();

	/**
	 * This is just a delegator to {@link #getLogContent()},
	 * which is a delegator to {@link SingleEntityNetwork#getLog()}.
	 * The visibility of {@link #getLogContent()} was not altered, for
	 * backward compatibility.
	 * @return log content
	 */
	public abstract String getLog();


	/**
	 * Open Warning dialog.
	 * Currently, this is only a stub.
	 */
	public abstract void openWarningDialog();

	/**
	 * Close current warning dialog.
	 * This is a stub yet.
	 */
	public abstract void closeWarningDialog();

	/**
	 * Preview the table printing.
	 */
	public abstract void previewPrintTable();

	/**
	 * Print the table.
	 */
	public abstract void printTable();

	/**
	 * Returns the selected node.
	 * @return the selected node.
	 */
	public abstract Node getSelectedNode();

	/**
	 * Selects a node
	 * @param node
	 */
	public abstract void selectNode(Node node);

	/**
	 * Unselects all graphical elements
	 */
	public abstract void unselectAll();

	/**
	 * This is the class responsible for storing the network controlled by this controller.
	 * {@link #setBaseIO(BaseIO)} must be set to a correct controller depending to what type of
	 * network this controller is dealing.
	 * @return the baseIO
	 */
	public abstract BaseIO getBaseIO();

	/**
	 * This is the class responsible for storing the network controlled by this controller.
	 * {@link #setBaseIO(BaseIO)} must be set to a correct controller depending to what type of
	 * network this controller is dealing.
	 * @param baseIO the baseIO to set
	 */
	public abstract void setBaseIO(BaseIO baseIO);

}