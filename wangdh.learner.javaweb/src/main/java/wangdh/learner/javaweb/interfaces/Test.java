package wangdh.learner.javaweb.interfaces;

import java.util.Comparator;

import wangdh.learner.javaweb.base.ValidRule;

public class Test implements Comparator<ValidRule> {

	@Override
	public int compare(ValidRule o1, ValidRule o2) {

		return o1.getValidOrder() - o2.getValidOrder();
	}

}
