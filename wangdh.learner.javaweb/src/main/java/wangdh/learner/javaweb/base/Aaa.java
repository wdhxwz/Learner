package wangdh.learner.javaweb.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import wangdh.learner.javaweb.interfaces.Test;

public class Aaa {

	public static void main(String[] args) {
		List<ValidRule> rules = new ArrayList<ValidRule>();

		ValidRule rule1 = new ValidRule();
		rule1.setValidOrder(1);

		ValidRule rule2 = new ValidRule();
		rule2.setValidOrder(2);

		ValidRule rule3 = new ValidRule();
		rule3.setValidOrder(3);

		ValidRule rule4 = new ValidRule();
		rule4.setValidOrder(4);

		rules.add(rule4);
		rules.add(rule1);
		rules.add(rule3);
		rules.add(rule2);
		
		for (ValidRule validRule : rules) {
			System.out.println(validRule.getValidOrder());
		}
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");

		Collections.sort(rules, new Test());

		for (ValidRule validRule : rules) {
			System.out.println(validRule.getValidOrder());
		}

	}

}
