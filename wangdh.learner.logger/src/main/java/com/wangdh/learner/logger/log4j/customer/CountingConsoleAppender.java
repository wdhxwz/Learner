package com.wangdh.learner.logger.log4j.customer;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.ErrorCode;
import org.apache.log4j.spi.LoggingEvent;

public class CountingConsoleAppender extends AppenderSkeleton {
	int counter = 0;
	int limit = 16;

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	/**
	 * 关掉
	 */
	@Override
	public void close() {
		if (this.closed) {
			return;
		}

		this.closed = true;
	}

	/**
	 * 需要使用布局
	 */
	@Override
	public boolean requiresLayout() {

		return true;
	}

	/**
	 * 日志记录
	 */
	@Override
	protected void append(LoggingEvent event) {
		if (this.layout == null) {
			errorHandler.error("没有设置[" + name + "]输出布局.", null, ErrorCode.MISSING_LAYOUT);

			return;
		}

		if (counter >= limit) {
			errorHandler.error("输出次数[" + limit + "]达到了极限.", null, ErrorCode.WRITE_FAILURE);

			return;
		}

		System.out.print(this.layout.format(event));
		if (layout.ignoresThrowable()) {
			String[] t = event.getThrowableStrRep();
			if (t != null) {
				for (String string : t) {
					System.out.println(string);
				}
			}
		}
		counter++;
	}
}
