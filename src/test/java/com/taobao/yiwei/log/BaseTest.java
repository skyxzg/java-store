package com.taobao.yiwei.log;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseTest {
//	protected final static Logger log = Logger.getLogger(BaseTest.class);
	protected final static Logger log = LoggerFactory.getLogger(BaseTest.class);
	
	// global parameter for distinguish case name
	protected String caseIdentifier = "";

	@Rule
	public TestWatcher watchman = new TestWatcher() {

		@Override
		protected void starting(Description d) {
			caseIdentifier = d.getClassName() + "." + d.getMethodName();
			String[] strArray = caseIdentifier.split("\\.");
			if (strArray.length > 1)
				log.info(String.format("%-10s", "starting:")
						+ strArray[strArray.length - 2] + "."
						+ strArray[strArray.length - 1]);
			else
				assertTrue("caseIdentifier failed! " + caseIdentifier, false);
		}

		@Override
		protected void succeeded(Description d) {
			caseIdentifier = d.getClassName() + "." + d.getMethodName();
			String[] strArray = caseIdentifier.split("\\.");
			if (strArray.length > 1)
				log.info(String.format("%-10s", "passed:")
						+ strArray[strArray.length - 2] + "."
						+ strArray[strArray.length - 1]);
			else
				assertTrue("caseIdentifier failed! " + caseIdentifier, false);
		}

		@Override
		protected void failed(Throwable e, Description d) {
			caseIdentifier = d.getClassName() + "." + d.getMethodName();
			String[] strArray = caseIdentifier.split("\\.");
			if (strArray.length > 1)
				log.info(String.format("%-10s", "failed:")
						+ strArray[strArray.length - 2] + "."
						+ strArray[strArray.length - 1]);
			else
				assertTrue("caseIdentifier failed! " + caseIdentifier, false);
		}

		@Override
		protected void finished(Description d) {
			// subAfter();
		}
	};
}
