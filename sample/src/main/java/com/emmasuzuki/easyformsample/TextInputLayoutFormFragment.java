/*
 * Copyright 2016 Emma Suzuki <emma11suzuki@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.emmasuzuki.easyformsample;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.emmasuzuki.easyform.EasyForm;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class TextInputLayoutFormFragment extends Fragment {

    @BindView(R.id.form)
    EasyForm easyForm;

    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.text_layout_input_form, container, false);

        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        unbinder.unbind();
    }

    @OnClick(R.id.submit_button)
    public void submitButtonClicked() {
        // Make sure to call easyForm.validate() when using showErrorOn = UNFOCUS
        easyForm.validate();

        if (easyForm.isValid()) {
            Log.e(getClass().getSimpleName(), "All values are valid. Ready to submit.");
        } else {
            Log.e(getClass().getSimpleName(), "The last input was invalid");
        }
    }
}
