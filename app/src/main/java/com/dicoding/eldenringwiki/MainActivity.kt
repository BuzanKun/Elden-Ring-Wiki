
package com.dicoding.eldenringwiki

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.eldenringwiki.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val list = ArrayList<Remembrances>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvRemembrances.setHasFixedSize(true)

        list.addAll(getListRemembrances())
        showRecyclerList()
    }

    @SuppressLint("Recycle")
    private fun getListRemembrances(): ArrayList<Remembrances> {
        val dataName = resources.getStringArray(R.array.remembrances_name)
        val dataDescription = resources.getStringArray(R.array.remembrances_description)
        val dataPhoto = resources.obtainTypedArray(R.array.remembrances_photo)
        val dataId = resources.getStringArray(R.array.remembrances_id)
        val dataBossName = resources.getStringArray(R.array.remembrances_boss)
        val dataRune = resources.getStringArray(R.array.remembrances_rune)
        val dataWeapon1 = resources.getStringArray(R.array.remembrances_weapon1)
        val dataWeapon2 = resources.getStringArray(R.array.remembrances_weapon2)
        val listRemembrances = ArrayList<Remembrances>()
        for (i in dataName.indices) {
            val remembrances = Remembrances(
                dataId[i],
                dataName[i],
                dataDescription[i],
                dataBossName[i],
                dataPhoto.getResourceId(i, -1),
                dataRune[i],
                dataWeapon1[i],
                dataWeapon2[i]
            )
            listRemembrances.add(remembrances)
            }
        return listRemembrances
    }

    private fun showRecyclerList() {
        binding.rvRemembrances.layoutManager = LinearLayoutManager(this)
        val listRemembrancesAdapter = ListItemAdapter(list)
        binding.rvRemembrances.adapter = listRemembrancesAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val moveIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}