package com.d7g.d7gback.contorllers;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

import com.d7g.d7gback.entity.Route;
import com.d7g.d7gback.entity.Meta;
import com.d7g.d7gback.services.ResponseResult;

@RestController
@Slf4j
public class RouterControllerNew {

    @GetMapping("/get-async-routes")
    public ResponseResult<List<Map<String, Object>>> getAsyncRoutes() {
        return ResponseResult.success(Arrays.asList(
        //     buildRouteStructure(buildpermissionRouter()),
            buildRouteStructure(buildTestManagementRouter()),
            buildRouteStructure(buildTestScriptRouter())
        ));
    }

    // 通用路由结构构建方法
    private Map<String, Object> buildRouteStructure(Route root) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("path", root.getPath());
        if (root.getComponent() != null) map.put("component", root.getComponent());
        if (root.getName() != null) map.put("name", root.getName());
        map.put("meta", buildMetaStructure(root.getMeta()));
        
        if (root.getChildren() != null && !root.getChildren().isEmpty()) {
            List<Map<String, Object>> children = new ArrayList<>();
            for (Route child : root.getChildren()) {
                children.add(buildRouteStructure(child));
            }
            map.put("children", children);
        }
        return map;
    }

    // Meta结构构建方法
    private Map<String, Object> buildMetaStructure(Meta meta) {
        Map<String, Object> metaMap = new LinkedHashMap<>();
        metaMap.put("title", meta.getTitle());
        if (meta.getIcon() != null) metaMap.put("icon", meta.getIcon());
        if (meta.getRank() != null) metaMap.put("rank", meta.getRank());
        if (meta.getRoles() != null) metaMap.put("roles", meta.getRoles());
        if (meta.getAuths() != null) metaMap.put("auths", meta.getAuths());
        return metaMap;
    }
    private Route buildpermissionRouter() {
        Meta permission_children_meta_level2_2 = new Meta("登录接口返回按钮权限",
                null,
                null,
                null,
                null);
        Meta permission_children_meta_level2_1 = new Meta("路由返回按钮权限",
                null,
                null,
                null,
                Arrays.asList("permission:btn:add",
                        "permission:btn:edit",
                        "permission:btn:delete"));
        Meta permission_children_meta_level1_2 = new Meta("按钮权限",
                null,
                null,
                Arrays.asList("admin", "common"),
                null);
        Meta permission_children_meta_level1_1 = new Meta("页面权限",
                null,
                null,
                Arrays.asList("admin", "common"),
                null);
        Meta permission_meta_level1 = new Meta("权限管理",
                "ep:lollipop",
                80,
                null,
                null);

        Route permission_children_route_level2_2 = new Route(
                "/permission/button/login",
                "permission/button/perms",
                "PermissionButtonLogin",
                permission_children_meta_level2_2,
                null);
        Route permission_children_route_level2_1 = new Route(
                "/permission/button/router",
                "permission/button/index",
                "PermissionButtonRouter",
                permission_children_meta_level2_1,
                null);
        Route permission_children_route_level1_2 = new Route(
                "/permission/button",
                null,
                null,
                permission_children_meta_level1_2,
                Arrays.asList(permission_children_route_level2_1,
                        permission_children_route_level2_2));
        Route permission_children_route_level1_1 = new Route(
                "/permission/page/index",
                null,
                "PermissionPage",
                permission_children_meta_level1_1,
                null);

        Route permissionRouter = new Route(
                "/permission",
                null,
                null,
                permission_meta_level1,
                Arrays.asList(
                        permission_children_route_level1_1,
                        permission_children_route_level1_2,
                        permission_children_route_level2_1,
                        permission_children_route_level2_2));

        return permissionRouter;

    }

    private Route buildTestManagementRouter() {
        Meta tm_children_meta_level1_4 = new Meta("缺陷管理",
                null,
                null,
                null,
                null);
        Meta tm_children_meta_level1_3 = new Meta("测试用例管理",
                null,
                null,
                null,
                null);
        Meta tm_children_meta_level1_2 = new Meta("测试计划管理",
                null,
                null,
                null,
                null);
        Meta tm_children_meta_level1_1 = new Meta("项目管理",
                null,
                null,
                null,
                null);
        Meta tm_meta_level1 = new Meta("测试管理",
                "ep:management",
                10,
                null,
                null);

        Route tm_children_route_level1_4 = new Route(
                "/testmanagement/defectmanagement/index",
                null,
                "DefectManagement",
                tm_children_meta_level1_4,
                null);
        Route tm_children_route_level1_3 = new Route(
                "/testmanagement/testcasemanagement/index",
                null,
                "TestCaseManagement",
                tm_children_meta_level1_3,
                null);
        Route tm_children_route_level1_2 = new Route(
                "/testmanagement/testplanmanagement/index",
                null,
                "TestPlanManagement",
                tm_children_meta_level1_2,
                null);
        Route tm_children_route_level1_1 = new Route(
                "/testmanagement/projectmanagement/index",
                null,
                "ProjectManagement",
                tm_children_meta_level1_1,
                null);
        Route tmRouter = new Route(
                "/testmanagement",
                null,
                null,
                tm_meta_level1,
                Arrays.asList(
                        tm_children_route_level1_1,
                        tm_children_route_level1_2,
                        tm_children_route_level1_3,
                        tm_children_route_level1_4));

        return tmRouter;
        
    }

    private Route buildTestScriptRouter() {
        Meta ts_children_meta_level2_5 = new Meta("自动化环境管理",
                null,
                null,
                null,
                null);
        Meta ts_children_meta_level2_4 = new Meta("自动化用例管理",
                null,
                null,
                null,
                null);
        Meta ts_children_meta_level2_3 = new Meta("自动化数据管理",
                null,
                null,
                null,
                null);
        Meta ts_children_meta_level2_2 = new Meta("自动化报告管理",
                null,
                null,
                null,
                null);
        Meta ts_children_meta_level2_1 = new Meta("自动化执行管理",
                null,
                null,
                null,
                null);
        Meta ts_children_meta_level1_1_3 = new Meta("性能自动化脚本管理",
                null,
                null,
                null,
                null);
        Meta ts_children_meta_level1_1_2 = new Meta("界面自动化脚本管理",
                null,
                null,
                null,
                null);
        Meta ts_children_meta_level1_1_1 = new Meta("接口自动化脚本管理",
                null,
                null,
                null,
                null);
        Meta ts_children_meta_level1_1 = new Meta("自动化脚本管理",
                null,
                null,
                null,
                null);
        Meta ts_meta_level1 = new Meta("自动化管理",
                "ep:management",
                10,
                null,
                null);

        Route ts_children_route_level2_5 = new Route(
                "/atenvironmentmanagement/index",
                null,
                "ATEnvironmentManagement",
                ts_children_meta_level2_5,
                null);
        Route ts_children_route_level2_4 = new Route(
                "/atcasemanagement/index",
                null,
                "ATCaseManagement",
                ts_children_meta_level2_4,
                null);
        Route ts_children_route_level2_3 = new Route(
                "/atdatamanagement/index",
                null,
                "ATDataManagement",
                ts_children_meta_level2_3,
                null);
        Route ts_children_route_level2_2 = new Route(
                "/atreportmanagement/index",
                null,
                "ATReportManagement",
                ts_children_meta_level2_2,
                null);
        Route ts_children_route_level2_1 = new Route(
                "/atexecutionmanagement/index",
                null,
                "ATExecutionManagement",
                ts_children_meta_level2_1,
                null);

        Route ts_children_route_level1_1_3 = new Route(
                "/ioatscriptmanagement/index",
                null,
                "IOATScriptManagement",
                ts_children_meta_level1_1_1,
                null);
        Route ts_children_route_level1_1_2 = new Route(
                "/uiatscriptmanagement/index",
                null,
                "UIATScriptManagement",
                ts_children_meta_level1_1_2,
                null);
        Route ts_children_route_level1_1_1 = new Route(
                "/performanceatscriptmanagement/index",
                null,
                "PFATScriptManagement",
                ts_children_meta_level1_1_3,
                null);
        Route ts_children_route_level1_1 = new Route(
                "/atscriptmanagement",
                null,
                "ATScriptManagement",
                ts_children_meta_level1_1,
                Arrays.asList(
                        ts_children_route_level1_1_1,
                        ts_children_route_level1_1_2,
                        ts_children_route_level1_1_3));

        Route tsRouter = new Route(
                "/testscriptmanagement",
                null,
                null,
                ts_meta_level1,
                Arrays.asList(
                        ts_children_route_level1_1,
                        ts_children_route_level2_1,
                        ts_children_route_level2_2,
                        ts_children_route_level2_3,
                        ts_children_route_level2_4,
                        ts_children_route_level2_5));

        return tsRouter;

    }
}