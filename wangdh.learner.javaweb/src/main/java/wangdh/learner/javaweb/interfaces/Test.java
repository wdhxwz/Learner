package wangdh.learner.javaweb.interfaces;

import java.util.Comparator;

public class Test implements Comparator<IValidator> {

	@Override
	public int compare(IValidator o1, IValidator o2) {

		return o1.getOrder() - o2.getOrder();
	}

}
