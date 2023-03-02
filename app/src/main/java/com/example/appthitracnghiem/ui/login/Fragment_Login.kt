package com.example.appthitracnghiem.ui.login

import android.content.Intent
import android.graphics.Paint
import android.graphics.Typeface
import android.net.Uri
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.appthitracnghiem.R
import com.example.appthitracnghiem.ui.base.BaseFragment
import com.example.appthitracnghiem.ui.home.home.HomeActivity
import kotlinx.android.synthetic.main.fragment__login.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment_Login.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment_Login : BaseFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        hidePasswordLogin.setOnClickListener {
            hidePassword()
        }

        forgetPassword.setOnClickListener {
            var fragmentForgetpassword : Fragment_ForgetPassword = Fragment_ForgetPassword()
            var fm : FragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            fm.setCustomAnimations(R.anim.animation_scale_enter_right,R.anim.animation_scale_exit_left,R.anim.animation_scale_enter_left,R.anim.animation_scale_exit_right)
            fm.addToBackStack("Fragment_ForgetPassword")
            fm.replace(R.id.loginContainerID,fragmentForgetpassword).commit()
        }

        clickLogin()

        setText()
    }

    /** set font*/
    private fun setText() {
        forgetPassword.paintFlags = Paint.UNDERLINE_TEXT_FLAG

        val semibold : Typeface? = ResourcesCompat.getFont(requireActivity(),R.font.svn_gilroy_semibold)
        textGoogle.typeface = semibold
        textFacebook.typeface = semibold
        textApple.typeface = semibold
    }

    private fun clickLogin() {
        registerNow.setOnClickListener {
            val intent: Intent = Intent(activity, RegisterActivity::class.java)
            startActivity(intent)
        }

        login.setOnClickListener {
            val intent : Intent = Intent(requireActivity(), HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        google.setOnClickListener{
            val intent : Intent = Intent()
            intent.setAction(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://accounts.google.com/v3/signin/identifier?dsh=S-620025444%3A1673854670857931&authuser=0&continue=http%3A%2F%2Fsupport.google.com%2Fmail%2Fanswer%2F8494%3Fhl%3Dvi%26co%3DGENIE.Platform%253DDesktop&ec=GAlAdQ&hl=vi&flowName=GlifWebSignIn&flowEntry=AddSession")
            startActivity(intent)
        }

        facebook.setOnClickListener{
            val intent : Intent = Intent()
            intent.setAction(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.facebook.com")
            startActivity(intent)
        }
    }

    private fun hidePassword() {
        if(passwordLogin.transformationMethod == PasswordTransformationMethod.getInstance()) {
            passwordLogin.transformationMethod = null
            hidePasswordLogin.setBackgroundResource(R.drawable.icon_show_password_grey)
        }else if(passwordLogin.transformationMethod == null){
            passwordLogin.transformationMethod = PasswordTransformationMethod.getInstance()
            hidePasswordLogin.setBackgroundResource(R.drawable.icon_hint_grey)
        }
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
        return inflater.inflate(R.layout.fragment__login, container, false)
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
         * @return A new instance of fragment Fragment_Login.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment_Login().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}