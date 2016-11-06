package net.play.club.daggertest.modle;

import net.play.club.daggertest.modle.entity.Flower;
import net.play.club.daggertest.modle.entity.Lily;
import net.play.club.daggertest.modle.entity.LilyFlower;
import net.play.club.daggertest.modle.entity.Rose;
import net.play.club.daggertest.modle.entity.RoseFlower;

import dagger.Module;
import dagger.Provides;

/**
 * 项目名称：DaggerTest
 * 类描述：
 * 创建人：fuzh2
 * 创建时间：2016/10/14 14:20
 * 修改人：fuzh2
 * 修改时间：2016/10/14 14:20
 * 修改备注：
 */

@Module
public class FlowerModule {
    @Provides
    @RoseFlower
    Flower provideRose() {
        return new Rose();
    }

    @Provides
    @LilyFlower
    Flower provideLily() {
        return new Lily();
    }
}
