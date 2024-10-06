package com.dicoding.eldenringwiki

import android.content.Intent
import android.os.Build
import android.os.Bundle
import com.dicoding.eldenringwiki.databinding.ActivityDetailBinding

class DetailActivity : GoBackActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val dataRemembrances = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("key_remembrance", Remembrances::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("key_remembrance")
        }

        binding.tvTitle.text = dataRemembrances?.name
        binding.ivRemembrances.setImageResource(dataRemembrances?.image ?: 0)
        binding.tvRemembrancesDescription.text = dataRemembrances?.description

        binding.includeRemembranceDetail.tvBossName.text = dataRemembrances?.bossName
        binding.includeRemembranceDetail.tvRuneValue.text = dataRemembrances?.rune + " Runes"
        binding.includeRemembranceDetail.tvWeaponChoice1.text = dataRemembrances?.weapon1
        binding.includeRemembranceDetail.tvWeaponChoice2.text = dataRemembrances?.weapon2

        binding.actionShare.setOnClickListener {
            val shareText = """
                Remembrance Name: ${dataRemembrances?.name}
                Description: ${dataRemembrances?.description}
                Obtainable by Defeating: ${dataRemembrances?.bossName}
                Can be sold for: ${dataRemembrances?.rune}
                Trade for Weapon Choice 1: ${dataRemembrances?.weapon1}
                Trade for Weapon Choice 2: ${dataRemembrances?.weapon2}
            """.trimIndent()

            val shareIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, shareText)
                type = "text/plain"
            }

            val shareIntentChooser = Intent.createChooser(shareIntent, "Share Remembrances")
            startActivity(shareIntentChooser)
        }
    }
}