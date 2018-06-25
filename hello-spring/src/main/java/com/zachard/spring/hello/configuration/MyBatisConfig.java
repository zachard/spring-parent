/*
 *  Copyright 2015-2017 zachard, Inc.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.zachard.spring.hello.configuration;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import com.zachard.spring.hello.constant.MybatisConstant;

/**
 * <code>mybatis</code>配置类, 主要用于创建{@link SqlSessionFactory}对象
 * 
 * <pre>
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
@Configuration
@EnableTransactionManagement
public class MyBatisConfig implements TransactionManagementConfigurer {

	@Autowired
	@Qualifier("customerDataSource")
	private DataSource dataSource;
	
	/**
	 * 获取事务管理器
	 */
	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return new DataSourceTransactionManager(dataSource);
	}
	
	/**
	 * 创建{@link SqlSessionFactory}对象,并注册为Bean
	 * 
	 * @return   {@link SqlSessionFactory}对象
	 */
	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactoryBean() {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setTypeAliasesPackage(MybatisConstant.MYBATIS_TYPE_ALIASES_PACKAGE);
        
        Properties sqlSessionFactoryProperties = new Properties();
        
        //全局映射器启用缓存
        sqlSessionFactoryProperties.put("cacheEnabled", true);
        //查询时，关闭关联对象即时加载以提高性能
        sqlSessionFactoryProperties.put("lazyLoadingEnabled", true);
        //设置关联对象加载的形态，此处为按需加载字段(加载字段由SQL指 定)，不会加载关联表的所有字段，以提高性能
        sqlSessionFactoryProperties.put("aggressiveLazyLoading", false);
        //对于未知的SQL查询，允许返回不同的结果集以达到通用的效果
        sqlSessionFactoryProperties.put("multipleResultSetsEnabled", true);
        //允许使用列标签代替列名 
        sqlSessionFactoryProperties.put("useColumnLabel", true);
        //允许使用自定义的主键值(比如由程序生成的UUID 32位编码作为键值)，数据表的PK生成策略将被覆盖
        sqlSessionFactoryProperties.put("useGeneratedKeys", true);
        //给予被嵌套的resultMap以字段-属性的映射支持
        sqlSessionFactoryProperties.put("autoMappingBehavior", MybatisConstant.AUTO_MAPPING_BEHAVIOR_VALUE);
        //对于批量更新操作缓存SQL以提高性能
        sqlSessionFactoryProperties.put("defaultExecutorType", MybatisConstant.DEFAULT_EXECUTOR_TYPE_VALUE);
        //数据库超过25000秒仍未响应则超时
        sqlSessionFactoryProperties.put("defaultStatementTimeout", MybatisConstant.DEFAULT_STATEMENT_TIMEOUT_VALUE);
        bean.setConfigurationProperties(sqlSessionFactoryProperties);
        
        // 解析mybatis的Mapper配置文件类
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        
        try {
			bean.setMapperLocations(resolver.getResources(MybatisConstant.MYBATIS_MAPPER_RESOURCE_PATH));
		} catch (IOException e) {
			System.err.println("加载mybatis映射文件异常" + e);
		} finally {
			try {
				return bean.getObject();
			} catch (Exception e) {
				System.err.println("返回SqlSessionFactory对象异常" + e);
			}
		}
        
        return null;
	}
	
	/**
	 * 创建SqlSession模版
	 * 
	 * @param sqlSessionFactory
	 * @return
	 */
	@Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
