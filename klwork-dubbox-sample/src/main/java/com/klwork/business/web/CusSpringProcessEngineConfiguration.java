/* Licensed under the Apache License, Version 2.0 (the "License");
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

package com.klwork.business.web;

import org.activiti.engine.impl.util.ReflectUtil;
import org.activiti.spring.SpringProcessEngineConfiguration;

import java.io.InputStream;

public class CusSpringProcessEngineConfiguration extends
		SpringProcessEngineConfiguration {
	// mybitis的位置
	private static final String MYBATIS_MAPPING_FILE = "mybaits-config/sql-map-activiti-config.xml";

	@Override
	protected InputStream getMyBatisXmlConfigurationSteam() {
		return ReflectUtil.getResourceAsStream(MYBATIS_MAPPING_FILE);
	}

	@Override
	protected void initJpa() {
		super.initJpa();
	}
}
