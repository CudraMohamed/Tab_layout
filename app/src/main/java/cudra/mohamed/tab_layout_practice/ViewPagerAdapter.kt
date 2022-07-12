package cudra.mohamed.tab_layout_practice

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter (fm: FragmentManager, var tabCount:Int):FragmentPagerAdapter(fm){
    override fun getCount(): Int {
        return tabCount
    }

    override fun getItem(position: Int): Fragment {
        return when(position){
            0->FirstFragment()
            1->SecondFragment()
            2->ThirdFragment()
            else -> FirstFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
//        return super.getPageTitle(position)
        return "Tab" + (position+1)
    }
}