package github.mrapee.rbac.common.generator;

import java.util.Scanner;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.commons.lang3.StringUtils;

/**
 * @program: rbac_shiro
 * @description: 使用MyBatis-Plus提供的代码生成器，快速生成Entity、Mapper、Mapper XML、Service、Controller等模块的代码
 * @author: yuan_shen
 * @create: 2019-12-19 17:44
 **/

public class CodeGenerator {

    //数据源
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/rbac_shiro?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    //数据库驱动
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    //数据库用户名
    private static final String USERNAME = "root";
    //数据库密码
    private static final String PASSWORD = "cfes123**";
    //作者
    private static final String AUTHOR = "MrApee";
    //包的基础路径
    private static final String BASE_PACKAGE_URL = "github.mrapee.rbac";
    //xml文件路径
    private static final String XML_PACKAGE_URL = "/src/main/resources/dao/";
    //xml文件模板
    private static final String XML_MAPPER_TEMPLATE_PATH = "templates/dao.xml";
    //mapper文件模板
    private static final String MAPPER_TEMPLATE_PATH = "templates/dao.java";
    //entity文件模板
    private static final String ENTITY_TEMPLATE_PATH = "templates/domain.java";
    //service文件模板
    private static final String SERVICE_TEMPLATE_PATH = "templates/service.java";
    //serviceImpl文件模板
    private static final String SERVICE_IMPL_TEMPLATE_PATH = "templates/serviceImpl.java";
    //controller文件模板
    private static final String CONTROLLER_TEMPLATE_PATH = "templates/controller.java";


    /**
     * 读取控制台内容
     */
    public static String scanner(String tip){
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()){
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)){
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args){
        //代码生成器
        AutoGenerator mpg = new AutoGenerator();

        //全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/rbac/src/main/java");
        gc.setAuthor(AUTHOR);
        gc.setOpen(false);
        gc.setFileOverride(false);
        //gc.setSwagger2(true);实体属性Swagger2注解
        mpg.setGlobalConfig(gc);

        //数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(URL);
        dsc.setDriverName(DRIVER_NAME);
        dsc.setUsername(USERNAME);
        dsc.setPassword(PASSWORD);
        mpg.setDataSource(dsc);

        //包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(scanner("模块名"));
        pc.setParent(BASE_PACKAGE_URL);
        mpg.setPackageInfo(pc);

        /*//自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {

            }
        };

        //自定义输出位置
        List<FileOutConfig> focList = new ArrayList<>();
        //自定义配置会被优先输出
        focList.add(new FileOutConfig() {
            @Override
            public String outputFile(TableInfo tableInfo) {
                //自定义输出文件名
                return projectPath + "/rbac/src/main/resources/dao/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);*/

        //配置自定义代码模板
        TemplateConfig tc = new TemplateConfig();
        tc.setXml(XML_MAPPER_TEMPLATE_PATH);
        tc.setMapper(MAPPER_TEMPLATE_PATH);
        tc.setEntity(ENTITY_TEMPLATE_PATH);
        tc.setService(SERVICE_TEMPLATE_PATH);
        tc.setServiceImpl(SERVICE_IMPL_TEMPLATE_PATH);
        tc.setController(CONTROLLER_TEMPLATE_PATH);
        mpg.setTemplate(tc);

        //配置策略
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        //写于父类中的公共字段
        strategy.setSuperEntityColumns("id");
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix("t_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }


}
