һ��Ϊ��ͳһ�������������������Թ���ͨ��dataProvider�����Դ���������������˸��룬��������ͳһ��src/test/resource/testcaseĿ¼��
���Դ���Ϊcom.airwallex.bank.BankTest

����defects/issues
1��Length of account_number should be between 7 and 11 when bank_country_code is 'US'
����ط��İ����󣬸�������,Ӧ����Length of account_number should be between 1 and 11 when bank_country_code is 'US'
2��account_number=12345678901234567890, bank_country_code=CN �������Ӧ�÷��سɹ�������ʵ�ʷ�����
����Length of account_number should be between 7 and 11 when bank_country_code is 'US'
3��bank_country_codeΪCN��AU���߼��ƺ���US��һ�£�û�а�����������
4��swift_codeֻ��Ϊ8��11λ��ʵ��9λҲ����
5����bankcountry code ��us ʱ��aba �����Ǳ��������ʵ��Ϊ��Ҳ�ܳɹ�



��������project ��github ��ַ��

�ġ������Ҫ��������ִ�У����ڱ�֤��װ�� java ��maven��testng������£������̸�Ŀ¼ִ�У� mvn clean test -Dtestng.xml

�塢����������� endpoint url��ַ������src/test/resource/config/conf.properties�ļ�������test_mode����.Ȼ��ִ��com.airwallex.bank.BankTest
