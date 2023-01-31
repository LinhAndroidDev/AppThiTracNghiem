package com.example.appthitracnghiem.ui.home.createtest

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.core.content.res.ResourcesCompat
import com.example.appthitracnghiem.R
import com.example.appthitracnghiem.ui.base.BaseFragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.fragment_create_test.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.layout_bottom_share.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentCreateTest.newInstance] factory method to
 * create an instance of this fragment.
 */
@Suppress("DEPRECATION")
class FragmentCreateTest : BaseFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var GALLERY_RED_CODE : Int = 1000

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setText()

        setBottomShare()

        menuCreateTest.setOnClickListener {
            showMenuCreate(it,R.menu.menu_create_test)
        }

        selectDepartment.setOnClickListener {
            showMenuCreate(it,R.menu.menu_select_khoa)
        }

        selectMode.setOnClickListener {
            showMenuCreate(it,R.menu.menu_mode)
        }

        addCoverImage.setOnClickListener {
            var intent : Intent = Intent(Intent.ACTION_PICK)
            intent.data = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            startActivityForResult(intent,GALLERY_RED_CODE)
        }

        googleSheet.setOnClickListener {
            var intent : Intent = Intent(requireActivity(),LinkSheetActivity::class.java)
            startActivity(intent)
        }

    }

    /** Share Test*/
    private fun setBottomShare() {
        layoutBottomShare.setOnTouchListener { v, event ->  true }
        var bottomShareBehavior = BottomSheetBehavior.from(layoutBottomShare)
        shareTest.setOnClickListener {
            if(bottomShareBehavior.state != BottomSheetBehavior.STATE_EXPANDED){
                bottomShareBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            }else{
                bottomShareBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            }
        }
    }


    /** Get Image from Storage*/
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == AppCompatActivity.RESULT_OK){
            if(requestCode == GALLERY_RED_CODE){
                imageCover.setImageURI(data?.data)
            }
        }
    }

    /** show menu add test */
    private fun showMenuCreate(view : View,menu: Int) {
        val popupMenu : PopupMenu = PopupMenu(requireActivity(),view)
        popupMenu.inflate(menu)
        popupMenu.setForceShowIcon(true)
        popupMenu.show()
    }

    /** set font **/
    private fun setText() {
        val semibold : Typeface? = ResourcesCompat.getFont(requireActivity(),R.font.svn_gilroy_semibold)
        txtThemDeThi.typeface = semibold
        txtTieuDe.typeface = semibold
        txtTaiDeLen.typeface = semibold
        txtChonKhoa.typeface = semibold
        txtChonCheDo.typeface = semibold
        txtThoiGianLamBai.typeface = semibold
        txtSoLuongCauHoi.typeface = semibold
        txtMoTa.typeface = semibold
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_test, container, false)
    }

    override fun onFragmentBack(): Boolean {
        return false
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentCreateTest.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentCreateTest().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}