package com.example.appthitracnghiem.ui.login

import android.app.ProgressDialog.show
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import com.example.appthitracnghiem.R
import com.example.appthitracnghiem.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment__create_password.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment_CreatePassword.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment_CreatePassword : BaseFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        resetPassword.setOnClickListener {
            var fragmentLogin : Fragment_Login = Fragment_Login()
            var fm : FragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            fm.setCustomAnimations(R.anim.animation_scale_enter_right,R.anim.animation_scale_exit_left,R.anim.animation_scale_enter_left,R.anim.animation_scale_exit_right)
            fm.replace(R.id.loginContainerID,fragmentLogin).commit()
        }

        hidePasswordCreate.setOnClickListener {
            if(passwordCreate.transformationMethod == PasswordTransformationMethod.getInstance()) {
                passwordCreate.transformationMethod = null
                hidePasswordCreate.setBackgroundResource(R.drawable.icon_show_password_grey)
            }else if(passwordCreate.transformationMethod == null){
                passwordCreate.transformationMethod = PasswordTransformationMethod.getInstance()
                hidePasswordCreate.setBackgroundResource(R.drawable.icon_hint_grey)
            }
        }

        hidePasswordRepeat.setOnClickListener {
            if(passwordRepeat.transformationMethod == PasswordTransformationMethod.getInstance()) {
                passwordRepeat.transformationMethod = null
                hidePasswordRepeat.setBackgroundResource(R.drawable.icon_show_password_grey)
            }else if(passwordRepeat.transformationMethod == null){
                passwordRepeat.transformationMethod = PasswordTransformationMethod.getInstance()
                hidePasswordRepeat.setBackgroundResource(R.drawable.icon_hint_grey)
            }
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
        return inflater.inflate(R.layout.fragment__create_password, container, false)
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
         * @return A new instance of fragment Fragment_CreatePassword.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment_CreatePassword().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}