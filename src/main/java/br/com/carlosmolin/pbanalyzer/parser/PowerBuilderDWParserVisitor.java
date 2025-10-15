package br.com.carlosmolin.pbanalyzer.parser;// Generated from PowerBuilderParser.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PowerBuilderDWParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PowerBuilderDWParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PowerBuilderDWParser#start_rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart_rule(PowerBuilderDWParser.Start_ruleContext ctx);
	/**
	 * Visit a parse tree produced by {@link PowerBuilderDWParser#header_rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeader_rule(PowerBuilderDWParser.Header_ruleContext ctx);
	/**
	 * Visit a parse tree produced by {@link PowerBuilderDWParser#datawindow_rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatawindow_rule(PowerBuilderDWParser.Datawindow_ruleContext ctx);
	/**
	 * Visit a parse tree produced by {@link PowerBuilderDWParser#datawindow_property}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatawindow_property(PowerBuilderDWParser.Datawindow_propertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PowerBuilderDWParser#table_attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_attribute(PowerBuilderDWParser.Table_attributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PowerBuilderDWParser#column_attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn_attribute(PowerBuilderDWParser.Column_attributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PowerBuilderDWParser#retrieve_attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRetrieve_attribute(PowerBuilderDWParser.Retrieve_attributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PowerBuilderDWParser#datawindow_property_attribute_sub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatawindow_property_attribute_sub(PowerBuilderDWParser.Datawindow_property_attribute_subContext ctx);
	/**
	 * Visit a parse tree produced by {@link PowerBuilderDWParser#attribute_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute_name(PowerBuilderDWParser.Attribute_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link PowerBuilderDWParser#identifier_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier_name(PowerBuilderDWParser.Identifier_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link PowerBuilderDWParser#attribute_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute_value(PowerBuilderDWParser.Attribute_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link PowerBuilderDWParser#numeric_atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumeric_atom(PowerBuilderDWParser.Numeric_atomContext ctx);
	/**
	 * Visit a parse tree produced by {@link PowerBuilderDWParser#dataTypeSub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataTypeSub(PowerBuilderDWParser.DataTypeSubContext ctx);
	/**
	 * Visit a parse tree produced by {@link PowerBuilderDWParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(PowerBuilderDWParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PowerBuilderDWParser#array_decl_sub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_decl_sub(PowerBuilderDWParser.Array_decl_subContext ctx);
	/**
	 * Visit a parse tree produced by {@link PowerBuilderDWParser#close_call_sub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClose_call_sub(PowerBuilderDWParser.Close_call_subContext ctx);
	/**
	 * Visit a parse tree produced by {@link PowerBuilderDWParser#expression_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_list(PowerBuilderDWParser.Expression_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link PowerBuilderDWParser#atom_sub_call1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom_sub_call1(PowerBuilderDWParser.Atom_sub_call1Context ctx);
	/**
	 * Visit a parse tree produced by {@link PowerBuilderDWParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(PowerBuilderDWParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link PowerBuilderDWParser#identifier_name_ex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier_name_ex(PowerBuilderDWParser.Identifier_name_exContext ctx);
	/**
	 * Visit a parse tree produced by {@link PowerBuilderDWParser#atom_sub_member1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom_sub_member1(PowerBuilderDWParser.Atom_sub_member1Context ctx);
	/**
	 * Visit a parse tree produced by {@link PowerBuilderDWParser#boolean_atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean_atom(PowerBuilderDWParser.Boolean_atomContext ctx);
}