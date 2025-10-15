package br.com.carlosmolin.pbanalyzer.parser;// Generated from PowerBuilderParser.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PowerBuilderDWParser}.
 */
public interface PowerBuilderDWParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PowerBuilderDWParser#start_rule}.
	 * @param ctx the parse tree
	 */
	void enterStart_rule(PowerBuilderDWParser.Start_ruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link PowerBuilderDWParser#start_rule}.
	 * @param ctx the parse tree
	 */
	void exitStart_rule(PowerBuilderDWParser.Start_ruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link PowerBuilderDWParser#header_rule}.
	 * @param ctx the parse tree
	 */
	void enterHeader_rule(PowerBuilderDWParser.Header_ruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link PowerBuilderDWParser#header_rule}.
	 * @param ctx the parse tree
	 */
	void exitHeader_rule(PowerBuilderDWParser.Header_ruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link PowerBuilderDWParser#datawindow_rule}.
	 * @param ctx the parse tree
	 */
	void enterDatawindow_rule(PowerBuilderDWParser.Datawindow_ruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link PowerBuilderDWParser#datawindow_rule}.
	 * @param ctx the parse tree
	 */
	void exitDatawindow_rule(PowerBuilderDWParser.Datawindow_ruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link PowerBuilderDWParser#datawindow_property}.
	 * @param ctx the parse tree
	 */
	void enterDatawindow_property(PowerBuilderDWParser.Datawindow_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link PowerBuilderDWParser#datawindow_property}.
	 * @param ctx the parse tree
	 */
	void exitDatawindow_property(PowerBuilderDWParser.Datawindow_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link PowerBuilderDWParser#table_attribute}.
	 * @param ctx the parse tree
	 */
	void enterTable_attribute(PowerBuilderDWParser.Table_attributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PowerBuilderDWParser#table_attribute}.
	 * @param ctx the parse tree
	 */
	void exitTable_attribute(PowerBuilderDWParser.Table_attributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PowerBuilderDWParser#column_attribute}.
	 * @param ctx the parse tree
	 */
	void enterColumn_attribute(PowerBuilderDWParser.Column_attributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PowerBuilderDWParser#column_attribute}.
	 * @param ctx the parse tree
	 */
	void exitColumn_attribute(PowerBuilderDWParser.Column_attributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PowerBuilderDWParser#retrieve_attribute}.
	 * @param ctx the parse tree
	 */
	void enterRetrieve_attribute(PowerBuilderDWParser.Retrieve_attributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PowerBuilderDWParser#retrieve_attribute}.
	 * @param ctx the parse tree
	 */
	void exitRetrieve_attribute(PowerBuilderDWParser.Retrieve_attributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PowerBuilderDWParser#datawindow_property_attribute_sub}.
	 * @param ctx the parse tree
	 */
	void enterDatawindow_property_attribute_sub(PowerBuilderDWParser.Datawindow_property_attribute_subContext ctx);
	/**
	 * Exit a parse tree produced by {@link PowerBuilderDWParser#datawindow_property_attribute_sub}.
	 * @param ctx the parse tree
	 */
	void exitDatawindow_property_attribute_sub(PowerBuilderDWParser.Datawindow_property_attribute_subContext ctx);
	/**
	 * Enter a parse tree produced by {@link PowerBuilderDWParser#attribute_name}.
	 * @param ctx the parse tree
	 */
	void enterAttribute_name(PowerBuilderDWParser.Attribute_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link PowerBuilderDWParser#attribute_name}.
	 * @param ctx the parse tree
	 */
	void exitAttribute_name(PowerBuilderDWParser.Attribute_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link PowerBuilderDWParser#identifier_name}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier_name(PowerBuilderDWParser.Identifier_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link PowerBuilderDWParser#identifier_name}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier_name(PowerBuilderDWParser.Identifier_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link PowerBuilderDWParser#attribute_value}.
	 * @param ctx the parse tree
	 */
	void enterAttribute_value(PowerBuilderDWParser.Attribute_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link PowerBuilderDWParser#attribute_value}.
	 * @param ctx the parse tree
	 */
	void exitAttribute_value(PowerBuilderDWParser.Attribute_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link PowerBuilderDWParser#numeric_atom}.
	 * @param ctx the parse tree
	 */
	void enterNumeric_atom(PowerBuilderDWParser.Numeric_atomContext ctx);
	/**
	 * Exit a parse tree produced by {@link PowerBuilderDWParser#numeric_atom}.
	 * @param ctx the parse tree
	 */
	void exitNumeric_atom(PowerBuilderDWParser.Numeric_atomContext ctx);
	/**
	 * Enter a parse tree produced by {@link PowerBuilderDWParser#dataTypeSub}.
	 * @param ctx the parse tree
	 */
	void enterDataTypeSub(PowerBuilderDWParser.DataTypeSubContext ctx);
	/**
	 * Exit a parse tree produced by {@link PowerBuilderDWParser#dataTypeSub}.
	 * @param ctx the parse tree
	 */
	void exitDataTypeSub(PowerBuilderDWParser.DataTypeSubContext ctx);
	/**
	 * Enter a parse tree produced by {@link PowerBuilderDWParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(PowerBuilderDWParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PowerBuilderDWParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(PowerBuilderDWParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PowerBuilderDWParser#array_decl_sub}.
	 * @param ctx the parse tree
	 */
	void enterArray_decl_sub(PowerBuilderDWParser.Array_decl_subContext ctx);
	/**
	 * Exit a parse tree produced by {@link PowerBuilderDWParser#array_decl_sub}.
	 * @param ctx the parse tree
	 */
	void exitArray_decl_sub(PowerBuilderDWParser.Array_decl_subContext ctx);
	/**
	 * Enter a parse tree produced by {@link PowerBuilderDWParser#close_call_sub}.
	 * @param ctx the parse tree
	 */
	void enterClose_call_sub(PowerBuilderDWParser.Close_call_subContext ctx);
	/**
	 * Exit a parse tree produced by {@link PowerBuilderDWParser#close_call_sub}.
	 * @param ctx the parse tree
	 */
	void exitClose_call_sub(PowerBuilderDWParser.Close_call_subContext ctx);
	/**
	 * Enter a parse tree produced by {@link PowerBuilderDWParser#expression_list}.
	 * @param ctx the parse tree
	 */
	void enterExpression_list(PowerBuilderDWParser.Expression_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link PowerBuilderDWParser#expression_list}.
	 * @param ctx the parse tree
	 */
	void exitExpression_list(PowerBuilderDWParser.Expression_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link PowerBuilderDWParser#atom_sub_call1}.
	 * @param ctx the parse tree
	 */
	void enterAtom_sub_call1(PowerBuilderDWParser.Atom_sub_call1Context ctx);
	/**
	 * Exit a parse tree produced by {@link PowerBuilderDWParser#atom_sub_call1}.
	 * @param ctx the parse tree
	 */
	void exitAtom_sub_call1(PowerBuilderDWParser.Atom_sub_call1Context ctx);
	/**
	 * Enter a parse tree produced by {@link PowerBuilderDWParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(PowerBuilderDWParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link PowerBuilderDWParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(PowerBuilderDWParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link PowerBuilderDWParser#identifier_name_ex}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier_name_ex(PowerBuilderDWParser.Identifier_name_exContext ctx);
	/**
	 * Exit a parse tree produced by {@link PowerBuilderDWParser#identifier_name_ex}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier_name_ex(PowerBuilderDWParser.Identifier_name_exContext ctx);
	/**
	 * Enter a parse tree produced by {@link PowerBuilderDWParser#atom_sub_member1}.
	 * @param ctx the parse tree
	 */
	void enterAtom_sub_member1(PowerBuilderDWParser.Atom_sub_member1Context ctx);
	/**
	 * Exit a parse tree produced by {@link PowerBuilderDWParser#atom_sub_member1}.
	 * @param ctx the parse tree
	 */
	void exitAtom_sub_member1(PowerBuilderDWParser.Atom_sub_member1Context ctx);
	/**
	 * Enter a parse tree produced by {@link PowerBuilderDWParser#boolean_atom}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_atom(PowerBuilderDWParser.Boolean_atomContext ctx);
	/**
	 * Exit a parse tree produced by {@link PowerBuilderDWParser#boolean_atom}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_atom(PowerBuilderDWParser.Boolean_atomContext ctx);
}