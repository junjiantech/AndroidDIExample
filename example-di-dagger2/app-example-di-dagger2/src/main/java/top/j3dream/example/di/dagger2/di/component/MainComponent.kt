package top.j3dream.example.di.dagger2.di.component

import dagger.Component
import top.j3dream.example.di.dagger2.di.module.EngineModule
import top.j3dream.example.di.dagger2.di.module.MainModule
import top.j3dream.example.di.dagger2.feature.MainActivity

/**
 * Main Activity DI Component
 * @author Jia Junjian
 * @since 2021/8/31 14:50
 *
 * 依赖需求方和依赖提供方之间的桥梁，需要调用该接口生成类的 inject 方法才能完成注入.
 * 被Component标注的接口在编译时会生成该接口的实现类，如当前类将会生成 DaggerMainComponent.
 */
@Component(
    modules = [MainModule::class, EngineModule::class],
    dependencies = [TrafficPoliceComponent::class]
)
interface MainComponent {

    /**
     * 此函数会告知 Dagger MainActivity 希望访问该图并请求注入.
     *
     * <p>不允许是父类, 如果这里是 AppComponentActivity 则会导致MainActivity中参数注入失败.</p>
     *
     * <p>Dagger 需要满足 LoginActivity 所需的所有依赖项（LoginViewModel 具有自己的依赖项）。
     * 如果您有多个请求注入的类，则必须通过这些类的确切类型在组件中明确声明它们。
     * 例如，如果您有请求注入的 LoginActivity 和 RegistrationActivity，则需要两种 inject() 方法，
     * 而不是涵盖这两种情况的一种通用方法。通用 inject() 方法不会告知 Dagger 需要提供的内容。接口中的函数可以具有任何名称，
     * 但在它们以参数形式接收要注入的对象时将其称为 inject() 是 Dagger 中的一种惯例</p>
     * @param mainActivity MainActivity
     */
    fun inject(mainActivity: MainActivity)
}