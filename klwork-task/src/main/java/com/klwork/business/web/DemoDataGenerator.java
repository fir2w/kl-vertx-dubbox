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

import com.klwork.business.domain.service.UserService;
import com.klwork.common.utils.spring.SpringApplicationContextUtil;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.Model;
import org.apache.commons.io.IOUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;


/**
 * @author Joram Barrez
 */
public class DemoDataGenerator  {

  final String MODEL_ID = "modelId";
  final String MODEL_NAME = "name";
  final String MODEL_REVISION = "revision";
  final String MODEL_DESCRIPTION = "description";
  
  protected static final Logger LOGGER = LoggerFactory.getLogger(DemoDataGenerator.class);

  protected transient ProcessEngine processEngine;
  public transient IdentityService identityService;
  protected transient RepositoryService repositoryService;
  protected transient UserService userService;
  
  protected boolean createDemoUsersAndGroups;
  protected boolean createDemoProcessDefinitions;
  protected boolean createDemoModels;
  protected boolean generateReportData;
  
  public void init() {
    this.identityService = processEngine.getIdentityService();
    this.repositoryService = processEngine.getRepositoryService();
    userService = (UserService) SpringApplicationContextUtil.getContext()
			.getBean("userService");
    
    if (createDemoUsersAndGroups) {
      initDemoGroups();
      initDemoUsers();
    }
    
    if (createDemoProcessDefinitions) {
      //initProcessDefinitions();
    }
    
    if (createDemoModels) {
      //initModelData();
    }
  }
  
  public void setProcessEngine(ProcessEngine processEngine) {
    this.processEngine = processEngine;
  }
  
  public void setCreateDemoUsersAndGroups(boolean createDemoUsersAndGroups) {
    this.createDemoUsersAndGroups = createDemoUsersAndGroups;
  }

  public void setCreateDemoProcessDefinitions(boolean createDemoProcessDefinitions) {
    this.createDemoProcessDefinitions = createDemoProcessDefinitions;
  }

  public void setCreateDemoModels(boolean createDemoModels) {
    this.createDemoModels = createDemoModels;
  }
  
  public void setGenerateReportData(boolean generateReportData) {
    this.generateReportData = generateReportData;
  }

  protected void initDemoGroups() {
    String[] assignmentGroups = new String[] {"management", "sales", "marketing", "engineering"};
    for (String groupId : assignmentGroups) {
      userService.createGroup(groupId, "assignment");
    }
    
    String[] securityGroups = new String[] {"user", "admin"};
    for (String groupId : securityGroups) {
      userService.createGroup(groupId, "security-role");
    }
  }
  
  protected void initDemoUsers() {
    userService.createUser("admin", "Admin", " ", "admin123456", "klwork.v@gmail.com", 
            "org/activiti/explorer/images/kermit.jpg",
            Arrays.asList("management", "sales", "marketing", "engineering", "user", "admin"),
            Arrays.asList("birthDate", "10-10-1955", "jobTitle", "Muppet", "location", "Hollywoord",
                          "phone", "+123456789", "twitterName", "alfresco", "skype", "activiti_kermit_frog"));
    
    userService.createUser("wangwei", "Wang", "Wei", "123456", "wangwei_fir@126.com", 
            "org/activiti/explorer/images/gonzo.jpg",
            Arrays.asList("management", "engineering","user"),
            null);
    userService.createUser("wtongzhen", "wtongzhen", "", "123456", "wtongzhen@126.com", 
            "org/activiti/explorer/images/fozzie.jpg",
            Arrays.asList("marketing", "engineering", "user"),
            null);
  }
  
  @SuppressWarnings("unused")
protected void initProcessDefinitions() {
    
    /*String deploymentName = "Demo processes";
    List<Deployment> deploymentList = repositoryService.createDeploymentQuery().deploymentName(deploymentName).list();
    if (deploymentList == null || deploymentList.size() == 0) {
    	DeploymentBuilder s = repositoryService.createDeployment()
        .name(deploymentName)
        .addClasspathResource("org/activiti/explorer/demo/process/createTimersProcess.bpmn20.xml")
        .addClasspathResource("org/activiti/explorer/demo/process/VacationRequest.bpmn20.xml")
        .addClasspathResource("org/activiti/explorer/demo/process/VacationRequest.png")
        .addClasspathResource("org/activiti/explorer/demo/process/FixSystemFailureProcess.bpmn20.xml")
        .addClasspathResource("org/activiti/explorer/demo/process/FixSystemFailureProcess.png")
        .addClasspathResource("org/activiti/explorer/demo/process/simple-approval.bpmn20.xml")
        .addClasspathResource("org/activiti/explorer/demo/process/Helpdesk.bpmn20.xml")
        .addClasspathResource("org/activiti/explorer/demo/process/Helpdesk.png")
        .addClasspathResource("org/activiti/explorer/demo/process/reviewSalesLead.bpmn20.xml");
    	Deployment dt = s.deploy();
    	System.out.println("Demo processes" + dt.getId() + "-------------" +  "  部署name" + dt.getName());
    }
    
    String reportDeploymentName = "Demo reports";
    deploymentList = repositoryService.createDeploymentQuery().deploymentName(reportDeploymentName).list();
    if (deploymentList == null || deploymentList.size() == 0) {
      repositoryService.createDeployment()
        .name(reportDeploymentName)
        .addClasspathResource("org/activiti/explorer/demo/process/reports/taskDurationForProcessDefinition.bpmn20.xml")
        .addClasspathResource("org/activiti/explorer/demo/process/reports/processInstanceOverview.bpmn20.xml")
        .addClasspathResource("org/activiti/explorer/demo/process/reports/helpdeskFirstLineVsEscalated.bpmn20.xml")
        .addClasspathResource("org/activiti/explorer/demo/process/reports/employeeProductivity.bpmn20.xml")
        .deploy();
    }*/
    
    String crowdsourcingName = "外包流程";
    List<Deployment> deploymentList = repositoryService.createDeploymentQuery().deploymentName(crowdsourcingName).list();
    //WW_TODO 数据库启动时加载流程文件
    if (deploymentList == null || deploymentList.size() == 0) {
    	DeploymentBuilder s = repositoryService.createDeployment()
        .name(crowdsourcingName)
        .addClasspathResource("com/klwork/flow/act-crowdsourcing.bpmn20.xml")
    	.addClasspathResource("com/klwork/flow/gather-crowdsourcing.bpmn20.xml");
        s.deploy();
        
    }else {
    	if(true){
	    	Deployment t = deploymentList.get(0);
	    	repositoryService.deleteDeployment(t.getId(), true);
	    	DeploymentBuilder s = repositoryService.createDeployment()
	    	        .name(crowdsourcingName)
	    	               .addClasspathResource("com/klwork/flow/act-crowdsourcing.bpmn20.xml")
	    	               .addClasspathResource("com/klwork/flow/gather-crowdsourcing.bpmn20.xml");
	    	Deployment dt = s.deploy();
	    	//System.out.println("部署id" + dt.getId() + "-------------" +  "  部署name" + dt.getName());
    	}
    }
    
   /* // Generate some data for the 'employee productivity' report
    if (generateReportData) {
      Date now = new Date();
      ClockUtil.setCurrentTime(now);
      for (int i=0; i<100; i++) {
        processEngine.getRuntimeService().startProcessInstanceByKey("escalationExample");
      }
      
      Random random = new Random();
      for (Task task : processEngine.getTaskService().createTaskQuery().list()) {
        processEngine.getTaskService().complete(task.getId());
  
       if (random.nextBoolean()) {
         now = new Date(now.getTime() + ((24 * 60 * 60 * 1000) + (60 * 60 * 1000)));
         ClockUtil.setCurrentTime(now);
       }
        
      }
      
      ClockUtil.reset();
    }*/
    
  }
  
  protected void initModelData() {
    createModelData("Demo model", "This is a demo model", "org/activiti/explorer/demo/model/test.model.json");
  }
  
  protected void createModelData(String name, String description, String jsonFile) {
    List<Model> modelList = repositoryService.createModelQuery().modelName("Demo model").list();
    
    if (modelList == null || modelList.size() == 0) {
    
      Model model = repositoryService.newModel();
      model.setName(name);
      
      ObjectNode modelObjectNode = new ObjectMapper().createObjectNode();
      modelObjectNode.put(MODEL_NAME, name);
      modelObjectNode.put(MODEL_DESCRIPTION, description);
      model.setMetaInfo(modelObjectNode.toString());
      
      repositoryService.saveModel(model);
      
      try {
        InputStream svgStream = this.getClass().getClassLoader().getResourceAsStream("org/activiti/explorer/demo/model/test.svg");
        repositoryService.addModelEditorSourceExtra(model.getId(), IOUtils.toByteArray(svgStream));
      } catch(Exception e) {
        LOGGER.warn("Failed to read SVG", e);
      }
      
      try {
        InputStream editorJsonStream = this.getClass().getClassLoader().getResourceAsStream(jsonFile);
        repositoryService.addModelEditorSource(model.getId(), IOUtils.toByteArray(editorJsonStream));
      } catch(Exception e) {
        LOGGER.warn("Failed to read editor JSON", e);
      }
    }
  }

}
