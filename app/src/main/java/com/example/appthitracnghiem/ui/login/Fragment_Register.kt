package com.example.appthitracnghiem.ui.login

import android.app.ProgressDialog.show
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.method.PasswordTransformationMethod
import android.text.style.StyleSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import com.example.appthitracnghiem.R
import com.example.appthitracnghiem.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment__register.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment_Register.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment_Register : BaseFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registerAccount.setOnClickListener {
            var fragmentCondition : Fragment_Condition = Fragment_Condition()
            var fm : FragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            fm.setCustomAnimations(R.anim.animation_scale_enter_right,R.anim.animation_scale_exit_left,R.anim.animation_scale_enter_left,R.anim.animation_scale_exit_right)
            fm.addToBackStack("Fragment_Register")
            fm.replace(R.id.registerContainerID,fragmentCondition).commit()
        }

        setText()

        loginNow.setOnClickListener {
//            var intent : Intent = Intent(activity, LoginActivity::class.java)
//            startActivity(intent)
            activity?.finish()
        }

        hidePasswordRegister.setOnClickListener {
            if(passwordRegister.transformationMethod == PasswordTransformationMethod.getInstance()) {
                passwordRegister.transformationMethod = null
                hidePasswordRegister.setBackgroundResource(R.drawable.icon_show_password_grey)
            }else if(passwordRegister.transformationMethod == null){
                passwordRegister.transformationMethod = PasswordTransformationMethod.getInstance()
                hidePasswordRegister.setBackgroundResource(R.drawable.icon_hint_grey)
            }
        }

        hidePasswordRegisterRepeat.setOnClickListener {
            if(passwordRegisterRepeat.transformationMethod == PasswordTransformationMethod.getInstance()) {
                passwordRegisterRepeat.transformationMethod = null
                hidePasswordRegisterRepeat.setBackgroundResource(R.drawable.icon_show_password_grey)
            }else if(passwordRegisterRepeat.transformationMethod == null){
                passwordRegisterRepeat.transformationMethod = PasswordTransformationMethod.getInstance()
                hidePasswordRegisterRepeat.setBackgroundResource(R.drawable.icon_hint_grey)
            }
        }
    }

    private fun setText() {
        var strText:String = "Bằng cách nhấp vào đăng ký, bạn đồng ý với Điều khoản và Điều kiện Sử dụng của chúng tôi"
        var text : SpannableString = SpannableString(strText)
        var boldStart : StyleSpan = StyleSpan(Typeface.BOLD)
        var boldEnd : StyleSpan = StyleSpan(Typeface.BOLD)
        text.setSpan(boldStart,43,53,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        text.setSpan(boldEnd,57,74,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        textString.text = text
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
        return inflater.inflate(R.layout.fragment__register, container, false)
    }

    override fun onFragmentBack(): Boolean {

        return true
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Fragment_Register.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment_Register().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}