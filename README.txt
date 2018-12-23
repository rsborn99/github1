一、为了统一管理测试用例，这个测试工程通过dataProvider将测试代码与测试数据做了隔离，测试数据统一在src/test/resource/testcase目录下
测试代码为com.airwallex.bank.BankTest

二、defects/issues
1、Length of account_number should be between 7 and 11 when bank_country_code is 'US'
这个地方文案错误，根据需求,应该是Length of account_number should be between 1 and 11 when bank_country_code is 'US'
2、account_number=12345678901234567890, bank_country_code=CN 这种情况应该返回成功，但是实际返回了
报错：Length of account_number should be between 7 and 11 when bank_country_code is 'US'
3、bank_country_code为CN、AU的逻辑似乎和US的一致，没有按照需求中来
4、swift_code只能为8或11位，实际9位也可以
5、当bankcountry code 是us 时，aba 参数是必填参数，实际为空也能成功



三、测试project 的github 地址：

四、如果需要用命令行执行：请在保证安装了 java 、maven、testng的情况下，到工程根目录执行： mvn clean test -Dtestng.xml

五、如果需求配置 endpoint url地址，请在src/test/resource/config/conf.properties文件中配置test_mode变量.然后执行com.airwallex.bank.BankTest
