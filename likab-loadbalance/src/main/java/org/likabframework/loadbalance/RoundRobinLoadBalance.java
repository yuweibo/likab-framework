/**
 * Copyright 2017-2020.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.likabframework.loadbalance;

import java.util.List;

/**
 * ClassName:RoundRobinLoadBalance
 * @author sxp
 * @date:2017年5月7日 下午6:05:53
 */
public class RoundRobinLoadBalance implements LoadBalance {
	
	/**
	 * int the pos 
	 */
	private static int pos;

	/* (non-Javadoc)
	 * @see org.likabframework.loadbalance.LoadBalance
	 * @see #loadBalance(java.lang.String, java.util.List)
	 */
	@Override
	public String loadBalance(String remoteIP, List<String> serverList) {
		String server = null;
		synchronized (RandomLoadBalance.class) {
			if (pos >= serverList.size()) {
				pos = 0;
			}
			server = serverList.get(pos);
			pos ++;
		}
		return server;
	}

	/* (non-Javadoc)
	 * @see org.likabframework.loadbalance.LoadBalance#getScheme()
	 */
	@Override
	public String getScheme() {
		return ROUND_ROBIN_LOADBALANCE;
	}
}
