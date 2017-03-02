package wangdh.learner.javaweb.requestAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import wangdh.learner.javaweb.base.InnerOpenApiContext;
import wangdh.learner.javaweb.interfaces.IRequestAdapter;
import wangdh.learner.javaweb.interfaces.IValidator;
import wangdh.learner.javaweb.validator.IPValidator;
import wangdh.learner.javaweb.validator.SignValidator;
import wangdh.learner.javaweb.validator.TimestampValidator;

public class EPlusRequestAdapter implements IRequestAdapter {

	@Override
	public InnerOpenApiContext buildContext(HttpServletRequest request) {
		InnerOpenApiContext context = new InnerOpenApiContext();

		String rawData = request.getParameter("data");
		String signData = request.getParameter("signData");

		context.setRawData(rawData);
		context.setSignData(signData);

		// 对rawData进行解密处理，然后获取对应json数据指定字段的值
		String data = rawData;
		context.setData(data);
		context.setChannelNo("");
		context.setIp("");
		context.setOptType("");

		// 获取请求的真实ip
		context.setRequestIp("");

		List<IValidator> validators = new ArrayList<>();
		validators.add(new IPValidator());
		validators.add(new SignValidator());
		validators.add(new TimestampValidator());

		context.setValidators(validators);
		context.setTargetService("");

		return context;
	}

	/*
	 * ServiceResult (non-Javadoc)
	 * 
	 * @see
	 * wangdh.learner.javaweb.interfaces.IRequestAdapter#buildServiceRequest(
	 * wangdh.learner.javaweb.base.InnerOpenApiContext)
	 */
	@Override
	public Object buildServiceRequest(InnerOpenApiContext context) {
		return "data=" + context.getRawData();
	}
}