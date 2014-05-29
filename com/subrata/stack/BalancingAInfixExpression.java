package com.subrata.stack;
/**
 * Given an infix expression (((A+B)*(C))) , we have to say that first and last braces are extra.
 * Idea : 1. Ignore operator and operands and push the opening braces.
 *        2. while getting closing braces check if it matches the popped opening braces if not report error.
 *        3. if stack has extra braces then also report error.
 * @author Subrata Saha.
 *
 */
public class BalancingAInfixExpression {

}
