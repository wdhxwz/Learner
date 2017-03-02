package wangdh.learner.javaweb.base;

import java.util.Map;

import wangdh.learner.javaweb.interfaces.IRequestAdapter;
import wangdh.learner.javaweb.interfaces.IRequestFrom;
import wangdh.learner.javaweb.interfaces.IResponseAdapter;

public class OASConfig {
	public static Map<String, IRequestAdapter> requestAdapterMap;
	public static Map<String, IRequestFrom> requestFromMap;
	public static Map<String, IResponseAdapter> reqponseAdapterMap;
}
