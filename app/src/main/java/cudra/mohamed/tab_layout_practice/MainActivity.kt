package cudra.mohamed.tab_layout_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import cudra.mohamed.tab_layout_practice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupTabLayout()
        setupViewPage()
    }
    private fun setupViewPage(){
        binding.viewPager.apply {
            adapter=ViewPagerAdapter(supportFragmentManager, binding.tabLayouts.tabCount)
            addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabLayouts))
        }
    }
    private fun setupTabLayout(){
        binding.tabLayouts.apply {
            addTab(this.newTab().setText("Tab 1"))
            addTab(this.newTab().setText("Tab 2"))
            addTab(this.newTab().setText("Tab 3"))

            //tabGravity=TabLayout.GRAVITY_FILL

            addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    tab?.position?.let {
                        binding.viewPager.currentItem=it
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {
                }
            })
        }
    }
}