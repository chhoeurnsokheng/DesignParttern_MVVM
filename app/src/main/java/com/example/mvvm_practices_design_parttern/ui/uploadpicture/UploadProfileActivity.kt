package com.example.mvvm_practices_design_parttern.ui.uploadpicture

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.mvvm_practices_design_parttern.R

class UploadProfileActivity : AppCompatActivity() {
    private lateinit var btnTakePhoto: Button
    var imageView: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_profile)
        btnTakePhoto = findViewById(R.id.button)
        imageView = findViewById(R.id.imageView)
        EnableRuntimePermission()

        btnTakePhoto.setOnClickListener(View.OnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, 7)
        })

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 7 && resultCode == RESULT_OK) {
            val bitmap = data!!.extras!!["data"] as Bitmap?
            imageView!!.setImageBitmap(bitmap)
        }
    }

    fun EnableRuntimePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
            Toast.makeText(this, "CAMERA permission allows us to Access CAMERA app", Toast.LENGTH_LONG).show()
        } else {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), RequestPermissionCode)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        result: IntArray
    ) {
        when (requestCode) {
            RequestPermissionCode -> if (result.size > 0 && result[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission Granted, Now your application can access CAMERA.", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Permission Canceled, Now your application cannot access CAMERA.", Toast.LENGTH_LONG).show()
            }
        }
    }

    companion object {
        const val RequestPermissionCode = 1
    }
}