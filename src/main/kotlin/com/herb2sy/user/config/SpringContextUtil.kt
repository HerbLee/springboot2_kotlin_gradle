import org.springframework.context.ApplicationContext



class SpringContextUtil private constructor(){

    private var applicationContext: ApplicationContext? = null

    companion object {
        val instance: SpringContextUtil by lazy {
            SpringContextUtil()
        }
    }

    fun init(applicationContext: ApplicationContext){
        this.applicationContext = applicationContext
    }

    public fun getApplicationContext():ApplicationContext{
        return this.applicationContext!!
    }

    fun getBean(name: String): Any? {
        return applicationContext?.getBean(name)
    }

    //通过类型获取上下文中的bean
    fun getBean(requiredType: Class<*>): Any? {
        return applicationContext?.getBean(requiredType)
    }



}