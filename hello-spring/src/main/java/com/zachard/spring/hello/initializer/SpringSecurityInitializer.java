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

package com.zachard.spring.hello.initializer;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.filter.DelegatingFilterProxy;

/**
 * {@link AbstractSecurityWebApplicationInitializer}用于将{@link DelegatingFilterProxy}
 * 注册为一个名为<code>springSecurityFilterChain</code>的过滤器,且注册的优先级最高,
 * 
 * <pre>
 * 这个类的作用相当于 web.xml 文件中加入如下配置:
 * {@code <filter> }
 * {@code     <filter-name>springSecurityFilterChain</filter-name>  }
 * {@code     <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>  }
 * {@code </filter>    }
 * {@code <filter-mapping>    }
 * {@code     <filter-name>springSecurityFilterChain</filter-name>    }
 * {@code     <url-pattern>/*</url-pattern>    }
 * {@code </filter-mapping>   }
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
public class SpringSecurityInitializer extends AbstractSecurityWebApplicationInitializer {

}
